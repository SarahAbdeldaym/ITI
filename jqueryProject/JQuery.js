let cartArr = [];

const add_item = (e) => {
  let cart_item_div = $(".cart_item_div.hidden").clone();
  cart_item_div.removeClass("hidden");
  let draggedmenu_item = e.parents(".item").clone();
  draggedmenu_item.removeClass("menu_item").addClass("cartItem");
  draggedmenu_item.children(".add_item_to_cart").remove();
  $(cart_item_div).appendTo(draggedmenu_item);
  draggedmenu_item.appendTo(".cart");
  let item_name = draggedmenu_item.children(".item_name").html();
  let item_price = draggedmenu_item.children(".item_price").html();
  let item_amount = 1;
  let item = {
    name: item_name,
    price: item_price,
    quantity: item_amount,
  };
  cartArr.push(item);
  render_bill();
};

const add_item_to_cart = (e) => {
  $(() => {
    let added = false;
    let draggedmenu_item_name = e.siblings(".item_name").html();
    if ($("body > .container > .right_part_div > .cart > .cartItem").html() == undefined) {
      add_item(e);
      added = true;
    } else {
      $("body > .container > .right_part_div > .cart > .cartItem").each(
        function () {
          if ($(this).children(".item_name").html() == draggedmenu_item_name) {
            amount_increase($(this).children(".cart_item_div").children("#amount_increase_btn"));
            added = true;
          }
        }
      );
    }
    if (added == false) {
      add_item(e);
    }
  });
};

$(() => {
  $(".cart").sortable({
    stop: function (e, ui) {
      if (e.clientX < 500) {
        remove_item($(ui.item));
        render_bill();
      }
    },
  });
});

const update_cart_var = () => {
  cartArr = [];
  $("body > .container > .right_part_div > .cart > .cartItem").each(function () {
    let item_name = $(this).children(".item_name").html();
    let item_price = Number($(this).children(".item_price").html());
    let item_amount = Number($(this).children(".cart_item_div").children(".item_amount").html());
    let item = {name: item_name, price: item_price, quantity: item_amount};
    cartArr.push(item);
  });
};

const remove_item = (itemObj) => {
  $(() => {
    itemObj.remove();
    update_cart_var();
    render_bill();
  });
};

const render_bill = () => {
  $(() => {
    let subtotal = 0;
    cartArr.forEach((element) => {
      subtotal += element.price * 1;
    });
    $(".bill > .bill_div_row > #subtotal").html(subtotal + " LE");
    $(".bill > .bill_div_row > #VAT").html(Math.ceil(subtotal * 0.14) + " LE");
    if ($("body > .container > .right_part_div > .cart > .cartItem").html() == undefined) {
      $(".bill > .bill_div_row > #delivery").html("0 LE");
    } else {
      $(".bill > .bill_div_row > #delivery").html("25 LE");
    }
    if (
      parseInt($(".bill > .bill_div_row > #subtotal").html()) +
        parseInt($(".bill > .bill_div_row > #VAT").html()) +
        parseInt($(".bill > .bill_div_row > #delivery").html()) >=
      300
    ) {
      $(".bill > .bill_div_row > #discount").html("-30 LE");
      $(".bill > .discount_text").html("discount added!");
    } else {
      $(".bill > .bill_div_row > #discount").html("0 LE");
      $(".bill > .discount_text").html(
        "Get 30 LE discount on orders over 300 LE"
      );
    }
    $(".bill > .bill_div_row > #orderTotal").html(
      parseInt($(".bill > .bill_div_row > #subtotal").html()) +
        parseInt($(".bill > .bill_div_row > #VAT").html()) +
        parseInt($(".bill > .bill_div_row > #delivery").html()) +
        parseInt($(".bill > .bill_div_row > #discount").html()) +
        " LE"
    );
  });
};

$(() => {
  $("body").on("click", ".add_item_to_cart", function () {
    add_item_to_cart($(this));
  });
  $("body").on("click", "#amount_increase_btn", function () {
    amount_increase($(this));
  });
  $("body").on("click", "#amount_decrease_btn", function () {
    amount_decrease($(this));
  });
  $("body").on("click", ".remove_btn", function () {
    remove_item($(this).parent(".cart_item_div").parent(".item"));
  });
});

const amount_increase = (e) => {
  $(() => {
    let oldQuantity = Number(e.siblings(".item_amount").html());
    let newQuantity = oldQuantity + 1;
    e.siblings(".item_amount").html(newQuantity);
    let oldPrice = Number(e.parent(".cart_item_div").siblings(".item_price").html());
    let unitPrice = oldPrice / oldQuantity;
    let newPrice = unitPrice * newQuantity;
    e.parent(".cart_item_div").siblings(".item_price").html(newPrice);
    update_cart_var();
    render_bill();
  });
};

$(() => {
  for (let element of items) {
    const itemObject = $(".item.hidden").clone();
    itemObject.addClass("menu_item").removeClass("hidden").appendTo(".menu");
    itemObject.children(".item_name").html(`${element.name}`);
    itemObject.children(".item_price").html(`${element.price}`);
    itemObject.children(".image").attr("src", element.src);
    itemObject.draggable({
      stop: function (e) {
        if (e.clientX > 1200 && 1000 - e.clientY > 350) {
          add_item_to_cart($(this).children(".add_item_to_cart"));
          render_bill();
        }
      },
      helper: "clone",
    });
  }
});

const amount_decrease = (e) => {
  $(() => {
    let oldQuantity = Number(e.siblings(".item_amount").html());
    let newQuantity = oldQuantity > 1 ? oldQuantity - 1 : 1;
    e.siblings(".item_amount").html(newQuantity);
    let oldPrice = Number(e.parent(".cart_item_div").siblings(".item_price").html());
    let unitPrice = oldPrice / oldQuantity;
    let newPrice = unitPrice * newQuantity;
    e.parent(".cart_item_div").siblings(".item_price").html(newPrice);
    update_cart_var();
    render_bill();
  });
};

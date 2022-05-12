import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/_models/product';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PasswordModule } from 'primeng/password';
import { RatingModule } from 'primeng/rating';
import { CalendarModule } from 'primeng/calendar';
import { ChipsModule } from 'primeng/chips';
import { GMapModule } from 'primeng/gmap';
import { FileUploadModule } from 'primeng/fileupload';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [
    new Product(1, "Face Primer", "gdn-0011", 3, new Date(2021, 2, 19), 19.59, "img.png"),
    new Product(2, "Foundation", "gdn-0023", 1, new Date(2021, 2, 18), 4.25, "img.png"),
    new Product(3, "Concealer", "gdn-0048", 2, new Date(2021, 4, 21), 8.90, "img.png"),
    new Product(4, "Face Powder", "gdn-0022", 5, new Date(2021, 4, 15), 11.55, "img.png"),
    new Product(5, "Lipgloss", "gdn-0042", 6, new Date(2020, 9, 15), 4.5, "img.png")
  ]

  filteredProducts: Product[] = [];
  newProduct: Product = new Product(0, " ", " ", 0, new Date(), 0.0, "img.png");
  viewProduct: Product = new Product(0, " ", " ", 0, new Date(), 0.0, "img.png");
  product: Product = new Product(0, " ", " ", 0, new Date(), 0.0, "img.png");

  productName = '';
  imgFlag = false;
  showFlag = false;
  editFlag = false;
  display: boolean = false;

  showDialog() {
      this.display = true;
  }

  showImage() {
    this.imgFlag = !this.imgFlag;
    console.log(this.imgFlag);
  }

  filter() {
    let count = 0;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].name.toLowerCase() === this.productName.toLowerCase()) {
        this.filteredProducts[count] = this.products[i];
        count++;
      }
    }
  }

  addNewProduct() {
    this.showFlag = false;
    this.editFlag = false;
    this.products.push(new Product(this.newProduct.id, this.newProduct.name, this.newProduct.code,this.newProduct.rate, this.newProduct.available, this.newProduct.price,this.newProduct.img));
    this.newProduct.id = 0;
    this.newProduct.name = " ";
    this.newProduct.code = " ";
    this.newProduct.available = new Date();
    this.newProduct.price = 0.0;
    this.newProduct.rate = 0;
  }




  showProduct(productId: number) {
    this.showFlag = true;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id == productId) {
        this.viewProduct = this.products[i];
        break;
      }
    }
  }



  editProduct(productId: number) {
    this.editFlag = true;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id == productId) {
        this.product = new Product(this.products[i].id, this.products[i].name, this.products[i].code, this.products[i].rate, this.products[i].available, this.products[i].price, this.products[i].img);
        break;
      }
    }
  }


  edit(productId: number) {
    this.editFlag = true;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id == productId) {
        this.products[i] = new Product(this.product.id, this.product.name, this.product.code, this.product.rate, this.product.available, this.product.price, this.product.img);
        break;
      }
    }
  }

  deleteProduct(productId: number) {
    this.showFlag = false;
    this.editFlag = false;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id == productId) {
        this.products.splice(i, 1);
        break;
      }
    }
    for (let i = 0; i < this.filteredProducts.length; i++) {
      if (this.filteredProducts[i].id == productId) {
        this.filteredProducts.splice(i, 1);
        break;
      }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}

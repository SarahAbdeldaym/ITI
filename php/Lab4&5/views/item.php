<?php
echo "<table border='1'>";
echo "<tr>";
if (isset($item)) {
    echo "<th>Type:$item->product_name</th>";

echo "<th>Price:$item->list_price</th>";
echo "</tr>";

echo "<tr>";
echo "<td><h5>Details:</h5><p>code:$item->PRODUCT_code</p><p>item id:$item->id</p><p>rating:$item->Rating</p></td>";
echo "<td><img src='images/$item->Photo' /></td>";
echo "</tr>";

echo "</table>";
}
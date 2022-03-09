<form action="" method="post">
    <input type="search" name="search" placeholder="Search By Name or Country" value="<?php echo isset($_POST['search']) ? $_POST['search'] : '' ?>">
    <input type="submit" name="search_submit"  value="Search">
</form>
<?php

echo "<table border='1'>";
$record_index = 0;
if (isset($all_records)) {
    foreach ($all_records as $item) {
        if ($record_index === 0) {
            echo "<tr>";
            echo "<td> Name </td>";
            echo "<td> Price </td>";
            echo "<td> Country </td>";
            echo "<td>Show More </td>";
            echo "</tr>";
        }
        echo "<tr>";

            echo "<td>".$item->product_name ."</td>";
            echo "<td>".$item->list_price ."</td>";
            echo "<td>".$item->CouNtry ."</td>";
            echo "<td><a href='http://localhost/phpLabs/Lab4&5/index.php?id=$item->id'>more</a></td>";
        echo "</tr>";

        $record_index ++;
    }
}
echo "</table>";
?>
<div> 
    <a href="<?php if (isset($previous_link)) {
        echo $previous_link;
    } ?>"> << Prev </a> | <a href="<?php if (isset($next_link)) {
        echo $next_link;
    } ?>">  Next >> </a>
</div>

<div>
    <p><?php if(_Debug_Mode_==1) if (isset($all_records_sql)) {
            echo $all_records_sql;
        } ?></p>
</div>




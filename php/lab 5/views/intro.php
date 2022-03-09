<?php

echo "<h5>" . $glasses->product_name . "<h5>";
echo "<h5>" . $glasses->Rating . "<h5>";

foreach ($searched_glasses as $key => $value) {
    echo "<h5>" . $key . ":" . $value . "</h5>";
}

echo "<h5> made in USA $usa_glasses_count glasses </h5>" ;
foreach ($usa_glasses as $glass) {
    echo "<br/>=====================<br/>";
    foreach ($glass as $key => $value) {
        echo "<h5>" . $key . ":" . $value . "</h5>";
    }
}





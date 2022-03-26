<?php

session_start();
require_once "vendor/autoload.php";
require_once "Views/selected_city_weather.php";

ini_set('memory_limit', '-1');

$string = file_get_contents('Resources/city.list.json');
$json_cities = json_decode($string, true);

if (isset($_POST["submit"])) {

    $id = $_POST["city"];

    $data = ConnectToAPI::api_connect($id);

    $City_name = $data["name"];
    $cloud_desc = $data["weather"][0]["main"] . ": " . $data["weather"][0]["description"];
    $Temp = "Temprsure: " . $data["main"]["temp_min"] . " C " . $data["main"]["temp_max"] . " C";
    $humaditiy = "Humidity: " . $data["main"]["humidity"] . " %";
    $wind = "Wind: " . $data["wind"]["speed"] . " km/h";

    echo "<center>" . $City_name . "</center>";
    echo "</br><center>" . $cloud_desc . "</center>";
    echo "</br><center>" . $Temp . "</center>";
    echo "</br><center>" . $humaditiy . "</center>";
    echo "</br><center>" . $wind . "</center>";
    die();
}
<?php

//open session and loading the composer
session_start();
require_once("vendor/autoload.php");

use Illuminate\Database\Capsule\Manager as dbConnection;

$dbConnection = new dbConnection();
$dbConnection->addConnection([
    "driver" => _driver_,
    "host" => _host_,
    "database" => _database_,
    "username" => _username_,
    "password" => _password_
]);
$dbConnection->setAsGlobal();
$dbConnection->bootEloquent();

if(!isset($_GET["id"])){
$index = (isset($_GET["index"]) && is_numeric($_GET["index"]) && $_GET["index"] > 0) ? (int) $_GET["index"] : 0;
$all_records= dbConnection::table("items")->skip($index)->take(_Pager_size_)->get();
if (isset($_POST['search_submit'])){
    if(!empty($_POST['search'])){
        $search_word = trim($_POST['search']);
        $all_records = dbConnection::table("items")->where("product_name", "like", "$search_word%")->
        orWhere("CouNtry", "like", "$search_word%")->get();
    }
}
$all_records_sql=dbConnection::table("items")->skip($index)->take(_Pager_size_)->toSql();
$all_records_count= dbConnection::table("items")->count();
$next_index = (($index + _Pager_size_)<=$all_records_count)?$index + _Pager_size_:0;
$next_link = "http://localhost/phpLabs/Lab4&5/index.php?index=$next_index";
$previous_index = (($index - _Pager_size_)>=0)?$index - _Pager_size_:0;
$previous_link = "http://localhost/phpLabs/Lab4&5/index.php?index=$previous_index";
require_once("views/table.php");
}
else{
    $item = dbConnection::table("items")->find((int)$_GET["id"]);
    require_once("views/item.php");
}


//$glasses = Capsule::table('items')->first();
//$searched_glasses = Capsule::table('items')->find(91);
//$usa_glasses_count = Capsule::table("items")->where("Country","=","USA")->count();
//$usa_glasses = Capsule::table("items")->where("Country","=","USA")->get();

//return response view

//require_once("views/intro.php");



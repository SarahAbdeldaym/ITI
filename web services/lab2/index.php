<?php

session_start();

require_once "vendor/autoload.php";

use Illuminate\Database\Capsule\Manager as Capsule;

$capsule = new Capsule();
$capsule->addConnection([
    "driver" => Driver,
    "host" => Host,
    "database" => Database,
    "username" => Username,
    "password" => Password,
]);

$capsule->setAsGlobal();
$capsule->bootEloquent();

$api = new ApiHelper();

$method = $api->get_method();
$resource = $api->get_resource();
$resource_id = $api->get_resource_id();

if ($method == "get") {
    if ($resource == "items") {
        try {
            $item = $capsule::table("items")->where('id', $resource_id)->first();
            if ($item != null) {
                $api->output(array("Resource found" => $item));
            } else {
                $api->output(array("Error" => "Resource id doesn't exist!"), 404);
            }
        } catch (\Illuminate\Database\QueryException $ex) {
            die($api->output(array("Error" => "Internal server error!"), 500));
        }
    } else {
        $api->output(array("Error" => "Resource doesn't exist!"), 404);
    }
} else {
    $api->output(array("Error" => "Method not allowed!"), 405);
};

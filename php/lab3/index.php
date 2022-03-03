<?php
//open session and loading the composer
session_start();
require_once "vendor/autoload.php";

//validate parameters and authenticate
if (isset($_POST["username"])) {
    if (Login::Authenticate($_POST["username"], $_POST["password"])) {
        $_SESSION["userid"] = 5;
    }

    // header("Location: index.php?page=user");
    $page = "user";

} else {
    //checking logging status
    if (!Login::check_login()) {
        $page = "login";
    } else {
        //calling my logic
        $my_user = new User("admin", "admin123", "engakarim@gmail.com");
        //routing
        $pages = array("login", "user");
        $page = (isset($_GET["page"]) && in_array($_GET["page"], $pages)) ?
        $_GET["page"] : "login";
    }
}
//return response view
require_once "views/$page.php";



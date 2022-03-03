<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Login
 *
 * @author memad
 */
class Login {
    
    
      
    static function check_login(){
    
        if(isset($_SESSION["userid"]) && is_numeric($_SESSION["userid"])){
            //logged in this visit
            return true;
        }elseif(isset($_COOKIE["remeber_me"])&&$_COOKIE["remeber_me"] == correct_token){
            //logged in in a previous visit and checked Reemeber me
            $_SESSION["userid"]=5;
            return true;
        }      
        
        else{
            return false;
        }
    }
    
    static function Authenticate($entered_username,$entered_password,$remeber_me=true){
        if($entered_username == correct_username && sha1($entered_password) == correct_password){
            if($remeber_me)self::Remember();
            return true;
        }else{
            return false;
        }
        
    }
    
    static function Remember(){
        setcookie("remeber_me", "ndjbdxc9898ccdmcdcdcdc22op2op2nd2099ddd9cdd99d9d9c333cccdccxxscddxxdssndndndnnjnji9i", 0);
    }
    
    
}

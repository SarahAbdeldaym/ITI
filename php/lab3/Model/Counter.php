<?php

class Counter
{
    
    public static function countVisitors()
    {   
        if (!isset($_SESSION["is_visited"])) {
            $_SESSION["is_visited"] = true;
            $counter = file("counter.txt");
            $counter = $counter[0]+ 1;
            $fp = fopen("counter.txt", "w+");
            fwrite($fp, $counter);
            fclose($fp);

        }
    }

}

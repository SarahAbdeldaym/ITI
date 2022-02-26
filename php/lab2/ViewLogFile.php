<?php

$imported_content = file("log.txt");



foreach ($imported_content as $line)
  {     
       $info = explode(",", $line);
       echo "<br/><b>Visited Date: </b>".$info[0]." ".$info[1]."<br/>";
       echo "<b>IP Address: </b>".$info[2]."<br/>";
       echo "<b>Email: </b>" . $info[3]."<br/>";
       echo "<b>Name: </b>" . $info[4]."<br/>";
       echo "--------------------------------<br/>";
  }
?>
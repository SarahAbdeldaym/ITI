<?php
class User {
	private $name, $email;

	public function __construct($name, $email) {
		$this->name = $name;
		$this->email = $email;		
	}

	
	 function validate() {
		if (!filter_var($this->name, FILTER_VALIDATE_EMAIL)) {
                return false;
            }	
            
             if ((strlen(trim($this->email)) > 7)) {
                     return false;
            }
	}
	
	public function get_name($name = null) {
	
	if($name==null){
	return $this->name;
	}
	else{
	$this->name = $name;
	echo("name added");
	}
		
	}

	public function get_email($email = null) {
	
	if($email==null){
	return $this->email;
	}
	else{
	$this->email = $email;
	echo("email added");
	}
		
	}
}

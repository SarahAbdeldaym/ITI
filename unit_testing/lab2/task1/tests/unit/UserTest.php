<?php

class UserTest extends PHPUnit\Framework\TestCase {
	private static $user;

	public static function setupBeforeClass() : void {
		self::$user= new User("sarah","sarahabdeldaym@gmail.com");
	}

	public function test_get_name_retuen_correct_name() {
		$this->assertTrue(
			self::$user->get_name() === "sarah"
		);
	}

	public function test_get_email_retuen_correct_email() {
		$this->assertTrue(
		self::$user->get_email() ===  "sarahabdeldaym@gmail.com"
		);
	}

        public function test_get_name_returns_valid_name() {
                $user = new user("jhbkshafkdgkhsfndslhglj","nglsdkjgglk");
                $this->assertTrue(
                        $user->validate() === false
                );
           
        }

	public function test_get_name_returns_valid_email() {
                $user = new user('jhbkshafkdgkhsfndslhglj' , 'nglsdkjgglk');
                $this->assertTrue(
                        $user->validate() === false
                ); 
        }
}

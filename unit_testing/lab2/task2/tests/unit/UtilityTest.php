<?php

class UtilityTest extends PHPUnit\Framework\TestCase{

    private $utility;

	public function setup() : void {
        $this->utility = new Utility();
    }

    public function test_user_matched_passwd(){
        $this->assertTrue($this->utility->validate_password_matching(139238,139221) === 0);
        $this->assertTrue($this->utility->validate_password_matching(139238, 139238) === 1);
    }

    public function test_user_token_length(){
        $this->assertTrue(strlen($this->utility->randomkey(13)) === 13);
    }

    public function test_user_name_length(){
        $this->assertTrue($this->utility->validate_userName("sarah") === 1);
        $this->assertTrue($this->utility->validate_userName("bdshfdhsfhhfsjhdfjhsdjgfhgdgjsgfdjhdhvjhdsfgjdvjvfdsjhvfjdhsvfjshvfhfhgdsjyfgjdfjsdhgsfyfjhdggsjdgfjyfdgjyfhgjdjdsgjhgdsjhgfsjdgfyeshbdfdgfbdshfdhsfhhfsjhdfjhsdjgfhgdgjsgfdjhdhvjhdsfgjdvjvfdsjhvfjdhsvfjshvfhfhgdsjyfgjdfjsdhgsfyfjhdggsjdgfjyfdgjyfhgjdjdsgjhgdsjhgfsjdgfyeshbdfdgfbdshfdhsfhhfsjhdfjhsdjgfhgdgjsgfdjhdhvjhdsfgjdvjvfdsjhvfjdhsvfjshvfhfhgdsjyfgjdfjsdhgsfyfjhdggsjdgfjyfdgjyfhgjdjdsgjhgdsjhgfsjdgfyeshbdfdgfbdshfdhsfhhfsjhdfjhsdjgfhgdgjsgfdjhdhvjhdsfgjdvjvfdsjhvfjdhsvfjshvfhfhgdsjyfgjdfjsdhgsfyfjhdggsjdgfjyfdgjyfhgjdjdsgjhgdsjhgfsjdgfyeshbdfdgfbdshfdhsfhhfsjhdfjhsdjgfhgdgjsgfdjhdhvjhdsfgjdvjvfdsjhvfjdhsvfjshvfhfhgdsjyfgjdfjsdhgsfyfjhdggsjdgfjyfdgjyfhgjdjdsgjhgdsjhgfsjdgfyeshbdfdgf") === 0);
    }

   

    public function test_user_passwd_validation(){
        $this->assertTrue($this->utility->validate_password_syntax("139238221") === 0);
        $this->assertTrue($this->utility->validate_password_syntax("sarahlola") === 0);
        $this->assertTrue($this->utility->validate_password_syntax("sarah139") === 0);
        $this->assertTrue($this->utility->validate_password_syntax("SarahAbdeldaym139238") === 1);
    }
    
    public function test_user_email_validation(){
        $this->assertTrue($this->utility->validate_email_syntax("@gmail.com") === 0);
        $this->assertTrue($this->utility->validate_email_syntax("lolo.com") === 0);
        $this->assertTrue($this->utility->validate_email_syntax("sarah@gmail") === 0);
        $this->assertTrue($this->utility->validate_email_syntax("sarahabdeldaym@gmail.com") === 1);
    }
   
}

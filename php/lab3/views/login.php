<?php

?>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Login Page </title>
</head>
<body>
    <center> <h1> Student Login Form </h1> </center>
    <form method="post" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
        <div class="container">
            <label>Username : </label>
            <input type="text" placeholder="Enter Username" name="username" required> </br>
            <label>Password : </label>
            <input type="password" placeholder="Enter Password" name="password" required> </br>
            <button type="submit">Login</button>
        </div>
    </form>
</body>
</html>



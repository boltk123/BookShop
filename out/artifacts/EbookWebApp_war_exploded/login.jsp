<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Login and Registration</title>
    <link rel="stylesheet" href="css/login.css" type="text/css">
</head>
<body>
	<div class="alaba">
        <div class="form-box">
            <div class="button-box">
                <div id="btn"></div>
                <button type="button" class="toggle-btn" onclick="login()">Log in</button>
                <button type="button" class="toggle-btn" onclick="register()">Register</button>
            </div>
            <div class="social-icons">
                <img src="image/zm.png">
                <img src="image/zl.png">
                <img src="image/yahoo.png">
            </div>
            <form id="login" class="input-group">
                <input type="text" class ="input-field" placeholder="User ID" required>
                <input type="text" class ="input-field" placeholder="Password" required>
                <input type="checkbox" class="check-box"><span>Remember password</span>
                <button type="submit" class="submit-btn">Log in</button>
            </form>
            <form id="register" class="input-group">
                <input type="text" class ="input-field" placeholder="User ID" required>
                <input type="email" class ="input-field" placeholder="Email" required>
                <input type="password" class ="input-field" placeholder="Password" required>
                <input type="checkbox" class="check-box"><span>I agree terms of service</span>
                <button type="submit" class="submit-btn">Register</button>
            </form>
        </div>
    </div>
    <script>
        var x=document.getElementById("login");
        var y=document.getElementById("register");
        var z=document.getElementById("btn");
        function register(){
            x.style.left = "-400px";
            y.style.left = "50px";
            z.style.left = "110px";
        }
        function login(){
            x.style.left = "50px";
            y.style.left = "450px";
            z.style.left = "0";
        }
    </script>
</body>
</html>
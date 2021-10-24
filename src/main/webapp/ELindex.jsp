<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
</head>
<body class="backgr">
    <div class="box">    
        <h1>Join our email list</h1>
        <p>To join our email list, enter your name and
           email address below.</p>

        <form action="emailListEL" method="post">
            <input type="hidden" name="action" value="add">        
            <label class="pad_top">Email:</label>
            <input type="email" name="email" 
                   value="${sessionScope.user.email}"><br>
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName" 
                   value="${sessionScope.user.firstName}"><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName" 
                   value="${sessionScope.user.lastName}"><br>        
            
            <div class="centered"><input class="button" type="submit" value="Join Now" class="margin_left"></div>
    </form>
    </div>
    <br>
    <form action="index.html">
        <div class="centered"><input class="button" type="submit"  value="Back To Home Page"></div>
    </form><br>
</body>
</html>
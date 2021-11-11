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
        <h2>Thanks for joining our email list</h2>

        <p>Here is the information that you entered:</p>


        <label>Email:</label>
        <span>${sessionScope.user.email}</span><br>
        <label>First Name:</label>
        <span>${sessionScope.user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${sessionScope.user.lastName}</span><br>

        <p>To enter another email address, click on the Back 
        button in your browser or the Return button shown 
        below.</p>

        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <div class="centered"><input class="button" type="submit" value="Return"></div>
        </form>
        <p>Current date: ${requestScope.currentDate}</p><br>
        <p>First users: ${users[0].email}</p><br>
        <p>Second users: ${users[1].email}</p><br>
        <p>Customer service email: ${initParam.custServEmail}</p>
        <br>
        <form action="index.jsp">
            <div class="centered"><input class="button" type="submit"  value="Home Page"></div>
        </form><br>
    </div>
</body>
</html>
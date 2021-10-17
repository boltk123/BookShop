<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>    
</head>

<body>
    <h1>Thanks for joining our email list</h1>

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
        <input type="submit" value="Return">
    </form>
    <p>Current date: ${requestScope.currentDate}</p><br>
    <p>First users: ${users[0].email}</p><br>
    <p>Second users: ${users[1].email}</p><br>
    <p>Customer service email: ${initParam.custServEmail}</p>
        
</body>
</html>
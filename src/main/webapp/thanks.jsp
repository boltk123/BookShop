<%@ page import="utility.URLUtil" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<body>
    <div class="backgr"> 
        <div class="box" id="thanks">
            <%@ include file="/includes/exercise_header.html" %>
            <h1>Thanks for joining our email list</h1>

            <p>Here is the information that you entered:</p><br>

            <label>Email:</label>
            <p>${user.email}</p><br>
            <label>First Name:</label>
            <p>${user.firstName}</p><br>
            <label>Last Name:</label>
            <p>${user.lastName}</p><br>
            <p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>
            <form action="survey.jsp" method="get">
                <div class="centered"><input type="submit" value="Survey"  class="button"></div>
            </form>
            <p>To enter another email address, click on the Back
                button in your browser or the Return button shown
                below.</p>

            <form action="" method="post">
                <input type="hidden" name="action" value="add">
                <div class="centered"><input type="submit" value="Return"  class="button"></div>
            </form>
            <p>Return to Homepage</p>
            <form action="index.jsp">
                <div class="centered"><input type="submit"  value="Back To Home Page"  class="button"></div>
            </form>
            <%@ include file="/includes/exercise_footer.jsp" %>
        </div>
    </div>
</body>
</html>
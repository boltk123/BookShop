<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="css/exercise.css">
        <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
    </head>
    <body>
        <div class="backgr">
            <div class="box" id="survey">    
                <form action="survey" method="post">
                    <h1>Survey</h1>
                    <p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>

                    <h2>Your information:</h2>
                    <label>First Name</label>
                    <input type="text" name="firstName" required><br>
                    <label>Last Name</label>
                    <input type="text" name="lastName" required><br>
                    <label>Email</label>
                    <input type="email" name="email" required><br>

                    <h2>How did you hear about us?</h2>
                    <p><input type=radio name="heardFrom" value="Search Engine">Search engine
                       <input type=radio name="heardFrom" value="Friend">Word of mouth
                       <input type=radio name="heardFrom" value="Other">Other</p>

                    <h2>Would you like to receive announcements about new CDs and special offers?</h2>
                    <p><input type="checkbox" name="wantsUpdates" checked>YES, I'd like that.</p>

                    <p>Please contact me by:
                        <select name="contactVia">
                            <option value="Both" selected>Email or postal mail</option>
                            <option value="Email">Email only</option>
                            <option value="Postal Mail">Postal mail only</option>
                        </select>
                    </p>

                    <div class="centered"><input type="submit" value="Submit" class="button"></div>
                </form>
            </div>
        </div>
    </body>
</html>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%  GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    request.setAttribute("currentYear", currentYear);%>
<p>&copy; Copyright ${currentYear} Mike Murach &amp; Associates</p>
</body>
</html>
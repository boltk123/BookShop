package features.email;

import business.Accounts;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.time.LocalDate;
import javax.mail.MessagingException;
@WebServlet(name = "EmailServlet", value = "/Email")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Accounts current_account = (Accounts)session.getAttribute("account");
        LocalDate purchase_date = LocalDate.now();
        purchase_date.plusDays(7);

        String email = current_account.getEmail();
        String to = email;
        String from = "nhanbuiduc.work@gmail.com";
        String subject = "Transaction Completed";
        String body = "Dear " + current_account.getFullname() + ",\n\n" +
                "You have successfully purchased your products\n " +
                "Thanks for ordering our ebook service. We'll make sure to send " +
                "your products in no time\n" +
                "Your packet will be arrive in " + purchase_date + " \n" +
                "Have a great day and thanks again!\n\n";
        boolean isBodyHTML = false;
        try
        {
            MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
        }
        catch (MessagingException e)
        {
            String errorMessage =
                    "ERROR: Unable to send email. " +
                            "Check Tomcat logs for details.<br>" +
                            "NOTE: You may need to configure your system " +
                            "as described in chapter 14.<br>" +
                            "ERROR MESSAGE: " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            this.log(
                    "Unable to send email. \n" +
                            "Here is the email you tried to send: \n" +
                            "=====================================\n" +
                            "TO: " + email + "\n" +
                            "FROM: " + from + "\n" +
                            "SUBJECT: " + subject + "\n" +
                            "\n" +
                            body + "\n\n");
        }
        String action = String.valueOf(request.getParameter("action"));
        String url = "/receipt.jsp";
        if(!action.equals("null")){
            url = "/ConfirmPayment";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}


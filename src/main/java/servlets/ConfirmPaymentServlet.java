package servlets;

import business.Accounts;
import business.Purchases;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmPaymentServlet", value = "/ConfirmPaymentServlet")
public class ConfirmPaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/HomePage";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();

        Accounts current_account = (Accounts)session.getAttribute("account");
        //Purchases
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

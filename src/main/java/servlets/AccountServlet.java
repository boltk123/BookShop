package servlets;

import business.Accounts;
import business.Purchases;
import com.paypal.api.payments.CarrierAccountToken;
import database.AccountsDB;
import database.PurchasesDB;
import exercise.nhanebook.UserDB_JDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/Account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url =" " ;
        HttpSession session = request.getSession();
        if (session.getAttribute("account") == null){
            url = "/login.jsp";
        } else {
            url = "/accountinfo.jsp";
        }
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package servlets;

import business.Accounts;
import business.Books;
import business.Products;
import business.Purchases;
import database.PurchasesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConfirmPaymentServlet", value = "/ConfirmPayment")
public class ConfirmPaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/vnpay_return.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        List<Products> productsList = (List<Products>) session.getAttribute("products");
        Accounts current_account = (Accounts)session.getAttribute("account");
        PurchasesDB.insertInvoice(current_account.getUser_id(), productsList);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

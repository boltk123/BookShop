package servlets;

import business.Accounts;
import business.Purchases;
import database.PurchasesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PurchaseHistoryServlet", value = "/PurchaseHistory")
public class PurchaseHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="/purchase-history.jsp";
        HttpSession session = request.getSession();
        Accounts account = (Accounts) session.getAttribute("account");
        List<Purchases> invoices = PurchasesDB.selectProcessedInvoices(account.getUser_id());
        session.setAttribute("invoices",invoices);

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

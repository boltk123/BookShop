package servlets;

import business.Accounts;
import business.Books;
import business.Purchases;
import database.BooksDB;
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
        String url= "/purchase_history.jsp";
        HttpSession session = request.getSession();
        Accounts account = (Accounts) session.getAttribute("account");
        List<Purchases> invoices = PurchasesDB.selectAllInvoices(account.getUser_id());
        List<Books> booksList = BooksDB.selectAllBooks();

        request.setAttribute("invoices",invoices);
        request.setAttribute("booksList",booksList);
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

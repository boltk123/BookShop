package servlets;

import business.Accounts;
import business.Purchase;
import com.paypal.api.payments.CarrierAccountToken;
import database.AccountsDB;
import exercise.nhanebook.UserDB_JDBC;
import business.Authors;
import business.Books;
import database.AuthorsDB;
import database.BooksDB;
import database.ProductsDB;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminDashboard")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int totalBooks = BooksDB.countBooks();
        String url = "/admin-dashboard.jsp";
        ServletContext sc = getServletContext();
        request.setAttribute("totalBooks", totalBooks);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

package servlets;

import business.Accounts;
import business.Books;
import database.BooksDB;
import database.PurchasesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WishListServlet", value = "/WishList")
public class WishListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/wishlist.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        Accounts current_account = (Accounts)session.getAttribute("account");
        //int user_id = current_account.getUser_id();
        //PurchasesDB wishlist1 = (PurchasesDB) PurchasesDB.selectProcessedInvoices(1);
        List<Books> wishlist = BooksDB.selectAllBooks();
        session.setAttribute("wishlist", wishlist);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

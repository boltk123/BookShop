package servlets;

import business.Accounts;
import business.Books;
import database.BooksDB;
import database.ProductsDB;
import database.PurchasesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/Detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        try{

            int book_id = Integer.parseInt((request.getParameter("book_id")));

            Books book = BooksDB.selectBooksByBookID(book_id);
            request.setAttribute("book", book);
            String url = "/detail.jsp";
            sc.getRequestDispatcher(url).
                    forward(request, response);
        }
        catch (Exception e){
            String url = "/login.jsp";
            sc.getRequestDispatcher(url).
                    forward(request, response);
        }

    }
}

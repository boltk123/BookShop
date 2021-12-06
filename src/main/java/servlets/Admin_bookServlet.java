package servlets;

import business.Accounts;
import business.Authors;
import business.Books;
import database.AuthorsDB;
import database.BooksDB;
import database.ProductsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin_bookServlet", value = "/AdminBooks")
public class Admin_bookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Books> books = BooksDB.selectAllBooks();
        ServletContext sc = getServletContext();
        String url = "/admin-books.jsp";
        String index_message = "LOG IN";
        HttpSession session = request.getSession();
        try{
            Accounts current_account = (Accounts) session.getAttribute("account");
            index_message = "Hello " + current_account.getFull_name();
        }
        catch(Exception e){
            index_message = "LOG IN";
        }
        request.setAttribute("books", books);
        request.setAttribute("indexmessage",index_message);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

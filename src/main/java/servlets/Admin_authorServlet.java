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

@WebServlet(name = "Admin_authorServlet", value = "/AdminAuthors")
public class Admin_authorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Authors> authors = AuthorsDB.selectAllAuthors();
        ServletContext sc = getServletContext();
        String url = "/admin-author.jsp";
        String index_message = "LOG IN";
        HttpSession session = request.getSession();
        try{
            Accounts current_account = (Accounts) session.getAttribute("account");
            index_message = "Hello " + current_account.getFull_name();
        }
        catch(Exception e){
            index_message = "LOG IN";
        }
        request.setAttribute("authors", authors);
        request.setAttribute("indexmessage",index_message);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

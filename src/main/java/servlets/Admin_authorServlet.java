package servlets;

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
        String indexmessage = "Log In";
        request.setAttribute("authors", authors);
        request.setAttribute("indexmessage",indexmessage);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package servlets;

import business.Authors;
import business.Books;
import database.AuthorsDB;
import database.BooksDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin_categoryServlet", value = "/AdminCategory")
public class Admin_categoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Books> category = BooksDB.selectBooksByGenre("Fiction");
        ServletContext sc = getServletContext();
        String url = "/admin-category.jsp";
        String indexmessage = "Log In";
        request.setAttribute("category", category);
        request.setAttribute("indexmessage",indexmessage);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


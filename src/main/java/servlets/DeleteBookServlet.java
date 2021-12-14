package servlets;

import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String url = "/AdminBooks";
        int book_id  = Integer.parseInt(request.getParameter("book_id"));
        BooksDB.removeBook(book_id);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

package servlets;

import business.Books;
import database.BooksDB;
import exercise.nhanebook.LineItem;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

@WebServlet(name = "ImageServlet", value = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> books = BooksDB.selectAllBooks();
        String url = "/imagetest.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        session.setAttribute("books", books);
        sc.getRequestDispatcher(url).
                forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

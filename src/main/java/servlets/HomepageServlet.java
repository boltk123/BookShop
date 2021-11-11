package servlets;

import business.Book_contents;
import business.Books;
import database.Book_contentsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "HomepageServlet", value = "/Homepage")
public class HomepageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book_contentsDB book_contentsDB = new Book_contentsDB();
        Book_contents bc = new Book_contents(1L);
        //book_contentsDB.insertBookCover(bc);
        HttpSession session = request.getSession();
        session.setAttribute("book", bc);
        String url = "/homepage.jsp";
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

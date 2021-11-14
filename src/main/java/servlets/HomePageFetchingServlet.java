package servlets;

import business.Books;
import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePageFetchingServlet", value = "/HomePage")
public class HomePageFetchingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> non_fiction_books = BooksDB.selectBooksByGenre("Non-Fiction");
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String url = "/homepage.jsp";
        int book_max = 4;
        int book_count = 1;
        for (Books book : non_fiction_books) {
            String book_name = "non_fiction_book" + Integer.toString(book_count);
            session.setAttribute(book_name, book);
            book_count += 1;
        }
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

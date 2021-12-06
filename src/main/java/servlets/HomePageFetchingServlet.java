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

@WebServlet(name = "HomePageFetchingServlet", value = "/HomePage")
public class HomePageFetchingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/homepage.jsp";
        List<Books> non_fiction_books = BooksDB.selectBooksByGenre("Non-Fiction");
        List<Books> fiction_books = BooksDB.selectBooksByGenre("Fiction");
        List<Books> academic_books = BooksDB.selectBooksByGenre("Academic");
        String index_message = "LOG IN";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        try{
            Accounts current_account = (Accounts) session.getAttribute("account");
            index_message = "Hello " + current_account.getFirstName();
        }
        catch(Exception e){
            index_message = "LOG IN";
        }

        session.setAttribute("non_fiction_books", non_fiction_books);
        session.setAttribute("fiction_books", fiction_books);
        session.setAttribute("academic_books", academic_books);
        request.setAttribute("indexmessage",index_message);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

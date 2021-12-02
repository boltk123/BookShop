package servlets;

import business.Books;
import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/Search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sqlQuery = "SELECT b FROM Books b";
        String url = "/search.jsp";
        HttpSession session = request.getSession();
        String genre = String.valueOf(request.getParameter("genre"));
        String key_word = String.valueOf(request.getParameter("key_word"));
        String p010 = String.valueOf(request.getParameter("p010"));
        String p1020 = String.valueOf(request.getParameter("p1020"));
        String p2030 = String.valueOf(request.getParameter("p2030"));
        String p30 = String.valueOf(request.getParameter("p30"));
        if(genre.contentEquals("all") == false || key_word.isEmpty() == false){
            sqlQuery += " WHERE";
        }

        if(genre.contentEquals("all") == false){
            if(genre != null){
                sqlQuery += " b.genre = '" + genre +"'";
            }
        }

        if(key_word.isEmpty() == false ){
            if (!genre.contentEquals("all")) {
                sqlQuery += " AND";
            }
            //sqlQuery += " b.title LIKE '%" + key_word + "%' OR b.genre LIKE '%" + key_word + "%'" + " OR b.author LIKE '%" + key_word + "%'";
            sqlQuery += " UPPER(b.title) LIKE UPPER('%" + key_word + "%') OR UPPER(b.genre) LIKE UPPER('%" + key_word + "%')" + " OR UPPER(b.author) LIKE UPPER('%" + key_word + "%')";
            sqlQuery += " OR LOWER(b.title) LIKE LOWER('%" + key_word + "%') OR LOWER(b.genre) LIKE LOWER('%" + key_word + "%')" + " OR LOWER(b.author) LIKE LOWER('%" + key_word + "%')";
        }
        List<Books> booksList = BooksDB.SearchBooks(sqlQuery);
        request.setAttribute("book_items", booksList);
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

package servlets;

import business.Books;
import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditLoadingServlet", value = "/EditFetching")
public class EditFetchingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/BooksTableInput.jsp";
        ServletContext sc = getServletContext();
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        try{
            Books current_book = BooksDB.selectBooksByBookID(book_id);
            request.setAttribute("book", current_book);
            sc.getRequestDispatcher(url).
                    forward(request, response);
        }
        catch (Exception e){
            sc.getRequestDispatcher(url).
                    forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

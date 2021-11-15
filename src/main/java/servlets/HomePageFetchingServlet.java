package servlets;

import business.Authors;
import business.Book_authors;
import business.Books;
import database.AuthorsDB;
import database.Book_authorsDB;
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
        List<Books> fiction_books = BooksDB.selectBooksByGenre("Fiction");
        List<Books> academic_books = BooksDB.selectBooksByGenre("Non-Fiction");
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String url = "/homepage.jsp";
        int book_max = 4;
        int book_count = 1;
        /*
        for (Books book : non_fiction_books) {
            String book_name = "non_fiction_book" + Integer.toString(book_count);
            List<Authors> non_fiction_book_authors = AuthorsDB.selectAuthorsByBookID(book.getBook_id());
            String author_name_list = "non_fiction_book_authors" + Integer.toString(book_count);
            session.setAttribute(book_name, book);
            session.setAttribute(author_name_list, non_fiction_book_authors);
            book_count += 1;
            if (book_count > book_max)
            {
                break;
            }
        }
        */
        session.setAttribute("non_fiction_books",non_fiction_books);
        for (Books book : non_fiction_books) {
            List<Authors> non_fiction_authors = AuthorsDB.selectAuthorsByBookID(book.getBook_id());
            List<Book_authors> non_fiction_book_authors = Book_authorsDB.selectBookAuthorsByBookID(book.getBook_id());

            book_count += 1;
            if (book_count > book_max)
            {
                break;
            }
        }
        book_max = 4;
        book_count = 1;
        for (Books book : fiction_books) {
            String book_name = "fiction_book" + Integer.toString(book_count);
            List<Authors> fiction_book_authors = AuthorsDB.selectAuthorsByBookID(book.getBook_id());
            String author_name_list = "non_fiction_book_authors" + Integer.toString(book_count);
            session.setAttribute(book_name, book);
            session.setAttribute(author_name_list, fiction_book_authors);
            book_count += 1;
            if (book_count > book_max)
            {
                break;
            }
        }
        book_max = 4;
        book_count = 1;
        for (Books book : academic_books) {
            String book_name = "academic_book" + Integer.toString(book_count);
            List<Authors> academic_book_authors = AuthorsDB.selectAuthorsByBookID(book.getBook_id());

            String author_name_list = "academic_book_authors"+ Integer.toString(book_count);
            session.setAttribute(book_name, book);
            session.setAttribute(author_name_list, academic_book_authors);
            book_count += 1;
            if (book_count > book_max)
            {
                break;
            }
        }
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

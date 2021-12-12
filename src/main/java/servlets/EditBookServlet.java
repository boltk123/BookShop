package servlets;

import business.Books;
import database.BooksDB;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "EditBookServlet", value = "/EditBook")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            final Part filePart = request.getPart("book_cover"); // Retrieves <input type="file" name="file">
            InputStream fileContent = filePart.getInputStream();
            byte[] bFile = IOUtils.toByteArray(fileContent);

            int book_id = Integer.parseInt((request.getParameter("book_id")));
            String title = request.getParameter("title");
            int total_pages = Integer.parseInt(request.getParameter("total_pages"));
            double rating = Double.parseDouble(request.getParameter("rating"));
            double cost = Double.parseDouble(request.getParameter("cost"));
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            String description = request.getParameter("description");

            final Part sample_part1 = request.getPart("book_sample1"); // Retrieves <input type="file" name="book_sample1">
            InputStream sample_stream1 = sample_part1.getInputStream();
            byte[] sample1 = IOUtils.toByteArray(sample_stream1);
            final Part sample_part2 = request.getPart("book_sample2"); // Retrieves <input type="file" name="book_sample2">
            InputStream sample_stream2 = sample_part2.getInputStream();
            byte[] sample2 = IOUtils.toByteArray(sample_stream2);
            final Part sample_part3 = request.getPart("book_sample3"); // Retrieves <input type="file" name="book_sample3">
            InputStream sample_stream3 = sample_part3.getInputStream();
            byte[] sample3 = IOUtils.toByteArray(sample_stream3);

            // pdf input
            final Part pdf_filePart = request.getPart("book_pdf");
            InputStream pdfFileBytes = null;
            pdfFileBytes = pdf_filePart.getInputStream();
            final byte[] pdf_bytes = new byte[pdfFileBytes.available()];
            pdfFileBytes.read(pdf_bytes);
            Books book = BooksDB.selectBooksByBookID(book_id);

            if(!title.isEmpty()){
                book.setTitle(title);
            }
            if(rating != 0){
                book.setRating(rating);
            }
            if(total_pages != 0){
                book.setTotal_pages(total_pages);
            }
            if(cost != 0){
                book.setCost(cost);
            }
            if(!author.isEmpty()){
                book.setAuthor(author);
            }
            if(!description.isEmpty()){
                book.setDescription(description);
            }

            if(!genre.isEmpty()){
                book.setGenre(genre);
            }
            if(bFile.length != 0){
                book.setBook_cover(bFile);
            }
            if(pdf_bytes.length != 0){
                book.setBook_pdf(pdf_bytes);
            }
            BooksDB.UpdateBook(book);
            RequestDispatcher rd = request.getRequestDispatcher("HomePage");
            rd.forward(request,response);
        }
        catch (FileNotFoundException fnf){

        }
    }
}

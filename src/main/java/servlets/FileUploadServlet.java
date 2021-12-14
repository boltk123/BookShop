package servlets;

import business.Book_contents;
import business.Books;
import database.Book_contentsDB;
import database.BooksDB;
import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FileUploadServlet", value = "/FileUpload")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class FileUploadServlet extends HttpServlet {
    public static final String PREFIX = "stream2file";
    public static final String SUFFIX = ".tmp";
    private static final long serialVersionUID = 1L;
    public static final String SAVE_DIRECTORY = "pdf";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if(action.contentEquals("Edit")){
            RequestDispatcher rd = request.getRequestDispatcher("EditBook");
            rd.forward(request,response);
        }
        else {
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
                /*
                final Part sample_part1 = request.getPart("book_sample1"); // Retrieves <input type="file" name="book_sample1">
                InputStream sample_stream1 = sample_part1.getInputStream();
                byte[] sample1 = IOUtils.toByteArray(sample_stream1);
                final Part sample_part2 = request.getPart("book_sample2"); // Retrieves <input type="file" name="book_sample2">
                InputStream sample_stream2 = sample_part2.getInputStream();
                byte[] sample2 = IOUtils.toByteArray(sample_stream2);
                final Part sample_part3 = request.getPart("book_sample3"); // Retrieves <input type="file" name="book_sample3">
                InputStream sample_stream3 = sample_part3.getInputStream();
                byte[] sample3 = IOUtils.toByteArray(sample_stream3);
                */
                // pdf input
                final Part pdf_filePart = request.getPart("book_pdf");
                InputStream pdfFileBytes = null;
                pdfFileBytes = pdf_filePart.getInputStream();
                final byte[] pdf_bytes = new byte[pdfFileBytes.available()];
                pdfFileBytes.read(pdf_bytes);

                // Insert books
                BooksDB.insertBook(book_id, title, total_pages, rating, cost, author, genre, description, bFile);

                // Insert PDF
                Book_contents book_content = new Book_contents(book_id, pdf_bytes);
                Book_contentsDB.InsertPDF(book_content);
                RequestDispatcher rd = request.getRequestDispatcher("AdminBooks");
                rd.forward(request,response);
            }
            catch (FileNotFoundException fnf){
                RequestDispatcher rd = request.getRequestDispatcher("EditBook");
                rd.forward(request,response);
            }
        }

    }
}

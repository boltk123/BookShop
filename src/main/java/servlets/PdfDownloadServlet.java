package servlets;

import business.Book_contents;
import business.Books;
import database.Book_contentsDB;
import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

@WebServlet(name = "PdfDownloadServlet", value = "/PdfDownload")
public class PdfDownloadServlet extends HttpServlet {

    // size of byte buffer to send file
    private static final int BUFFER_SIZE = 50000;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        Books book = BooksDB.selectBooksByBookID(book_id);
        Book_contents book_content = Book_contentsDB.SelectBookPDF(book_id);
        String fileName = book.getTitle()+".pdf";
        byte[] pdf_blob = book_content.getBook_pdf();
        InputStream pdf_inputStream = new ByteArrayInputStream(pdf_blob);
        int fileLength = pdf_inputStream.available();
        System.out.println("fileLength = " + fileLength);
        // sets MIME type for the file download
        String mimeType = context.getMimeType(fileName);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        // set content properties and header attributes for the response
        response.setContentType(mimeType);
        response.setContentLength(fileLength);
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);
        // writes the file to the client
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = pdf_inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        pdf_inputStream.close();
        outStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

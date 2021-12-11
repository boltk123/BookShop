package servlets;

import business.Books;
import database.BooksDB;
import database.SamplesDB;
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

        BooksDB.insertBook(book_id, title, total_pages, rating, cost, author, genre, description, bFile);
        SamplesDB.insertSample(book_id, bFile);
        SamplesDB.insertSample(book_id, sample1);
        SamplesDB.insertSample(book_id, sample2);
        SamplesDB.insertSample(book_id, sample3);
        RequestDispatcher rd = request.getRequestDispatcher("HomePage");
        rd.forward(request,response);

    }
    void pdfInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String description = request.getParameter("description");
            System.out.println("Description: " + description);


            //
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');


            //
            String fullSavePath = null;
            if (appPath.endsWith("/")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "/" + SAVE_DIRECTORY;
            }


            //
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            //
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    String filePath = fullSavePath + File.separator + fileName;
                    System.out.println("Write attachment to file: " + filePath);

                    //
                    part.write(filePath);
                }
            }

            //
            response.sendRedirect(request.getContextPath() + "/uploadFileResults");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/uploadFile.jsp");
            dispatcher.forward(request, response);
        }
    }
    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
}

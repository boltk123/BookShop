package servlets;

import business.Books;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
        }
        */
        response.setContentType("text/html;charset=UTF-8");
        final Part filePart = request.getPart("book_cover"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        System.out.println("Hibernate save image into database");
        //Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        //final File file = File.createTempFile(PREFIX, SUFFIX);
        //File file = new File("C://");
        //save image into database
        //FileUtils.copyInputStreamToFile(fileContent, file);
        // Book cover in binary format
        byte[] bFile = IOUtils.toByteArray(fileContent);
        /*
        try {
            //FileInputStream fileInputStream = new FileInputStream(file);
            FileInputStream fileInputStream = new FileInputStream(String.valueOf(fileContent));
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // insert into database
        int book_id = Integer.parseInt((request.getParameter("book_id")));
        String title = request.getParameter("title");
        String date = request.getParameter("published_date");
        try {
            Date published_date = new SimpleDateFormat("yyyy-mm-dd").parse(date);
            int published_id = Integer.parseInt(request.getParameter("published_id"));
            int total_pages = Integer.parseInt(request.getParameter("total_pages"));
            double rating = Double.parseDouble(request.getParameter("rating"));
            double cost = Double.parseDouble(request.getParameter("cost"));
            String description = request.getParameter("description");
            BooksDB.insertBook(book_id, title, total_pages, rating, cost, published_date, published_id, description, bFile);
            RequestDispatcher rd = request.getRequestDispatcher("ImageServlet");
            rd.forward(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //session.save(bookContents);
        /*
        //Get image from database
        Book_contents avatar2 = (Book_contents)session.get(Book_contents.class, bookContents.getBook_id());
        byte[] bAvatar = avatar2.getBook_cover();

        try{
            FileOutputStream fos = new FileOutputStream("C:\\test2.png");
            fos.write(bAvatar);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        */
        //session.getTransaction().commit();
    }
}

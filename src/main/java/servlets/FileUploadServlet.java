package servlets;

import business.Book_contents;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import utility.HibernateUtil;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileUploadServlet", value = "/FileUpload")

@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletFileUpload sf = new ServletFileUpload( new DiskFileItemFactory());
        try {
            List<FileItem> multifiles = sf.parseRequest(request);
            for(FileItem item: multifiles)
            {
                System.out.println("Hibernate save image into database");
                Session session = HibernateUtil.getSessionFactory().openSession();

                session.beginTransaction();

                //save image into database
                File file = new File("C:\\test.png");
                byte[] bFile = new byte[(int) file.length()];

                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    //convert file into array of bytes
                    fileInputStream.read(bFile);
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Book_contents bookContents = new Book_contents();
                bookContents.setBook_cover(bFile);

                session.save(bookContents);

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

                session.getTransaction().commit();
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}

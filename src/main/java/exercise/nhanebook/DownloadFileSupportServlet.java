package exercise.nhanebook;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* Servlet hỗ trợ tải các định dạng file" */
@WebServlet(name = "DownloadFileSupportServlet", value = "/DownloadFileSupportServlet")
public class DownloadFileSupportServlet extends HttpServlet {

    //source https://www.youtube.com/watch?v=3V1WDwBD8xA
    final String[][] contentTypes = {{"xml", "text/xml"}, {"pdf", "application/pdf"}, {"mp3", "audio/mpeg"}};
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // final String file_location = "D:/Heroku/src/main/webapp/sound/8601";
        // Tên của file
        Object requestObject = request.getParameter("filename");
        String directory = (String) request.getParameter("directory");
        if(requestObject != null){
            String fileName = (String) requestObject;
            String contentType = getContentType(fileName.split("\\.")[1]);
            String path = getServletContext().getRealPath(directory + fileName);
            //File file = new File(file_location + "/" + fileName);
            File file = new File(path);
            response.setContentType(contentType);
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentLength((int)file.length());
            ServletOutputStream servletOutputStream = response.getOutputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int bytesRead = bufferedInputStream.read();
            while (bytesRead != - 1){
                servletOutputStream.write(bytesRead);
                bytesRead = bufferedInputStream.read();
            }
            if( servletOutputStream != null) servletOutputStream.close();
            if( bufferedInputStream != null) bufferedInputStream.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private String getContentType(String fileType){
        String returnType = null;
        for (int i = 0; i < contentTypes.length; i++){
            if(fileType.equals(contentTypes[i][0])){
                returnType = contentTypes[i][1];
            }
        }
        return returnType;
    }
}

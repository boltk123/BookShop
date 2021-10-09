package exercise.nhanebook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="/testJSP.jsp";

        String message ="Xai post method";
        request.setAttribute("message",message);
        System.out.println("Post mehtod");

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message ="Xai get method";
        String url="/testJSP.jsp";
        request.setAttribute("message",message);
        System.out.println("Post mehtod");
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

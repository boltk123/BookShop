package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/LogOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/HomePage";
        HttpSession session = request.getSession();
        ServletContext sc = getServletContext();
        session.removeAttribute("account");
        session.removeAttribute("indexmessage");
        session.removeAttribute("loginmessage");
        session.removeAttribute("products");
        session.removeAttribute("book_items");
        session.removeAttribute("product_count");
        session.removeAttribute("tax");
        session.removeAttribute("shipping");
        session.removeAttribute("subtotal");
        session.removeAttribute("total");
        session.removeAttribute("vnd_total");
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

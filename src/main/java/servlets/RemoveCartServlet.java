package servlets;

import database.ProductsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveCartServlet", value = "/RemoveCart")
public class RemoveCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        //int user_id = Integer.parseInt(request.getParameter("user_id"));
        int book_id  = Integer.parseInt(request.getParameter("book_id"));
        ProductsDB.removeProduct(1, book_id);
        String url = "/ShoppingCart";
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

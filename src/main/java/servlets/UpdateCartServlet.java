package servlets;

import business.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateCartServlet", value = "/UpdateCart")
public class UpdateCartServlet extends HttpServlet {
    private static final double tax = 3;
    private static final double shipping = 10;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/shopping_list.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        List<Products> productsList = (List) session.getAttribute("productsList");
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

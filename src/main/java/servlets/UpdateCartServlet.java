package servlets;

import business.Accounts;
import business.Products;
import database.ProductsDB;

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
        String url = "/ShoppingCart";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        Accounts current_account = (Accounts) session.getAttribute("account");
        String action = request.getParameter("action");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int product_id = Integer.parseInt(request.getParameter("book_id"));
        if(action.contentEquals("plus")){
            ProductsDB.setQuantity(quantity + 1, current_account.getUser_id(), product_id);
        }
        else{
            ProductsDB.setQuantity(quantity - 1 , current_account.getUser_id(), product_id);
        }
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

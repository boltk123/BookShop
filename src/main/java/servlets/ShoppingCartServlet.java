package servlets;

import business.Accounts;
import business.Books;
import business.Products;
import database.BooksDB;
import database.ProductsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    private static final double tax = 3;
    private static final double shipping = 10;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/shopping_list.jsp";
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String action = String.valueOf(request.getParameter("action"));
        try{
            Accounts current_account = (Accounts)session.getAttribute("account");
            int user_id = current_account.getUser_id();
            List<Books> books = BooksDB.selectBooksByUserID(user_id);
            List<Products> products = ProductsDB.getProductList(user_id);
            int product_count = products.size();
            double subtotal = 0;
            for(Products product: products){
                subtotal += product.getTotal();
            }
            double total = subtotal + tax + shipping;
            session.setAttribute("products", products);
            session.setAttribute("book_items", books);
            session.setAttribute("product_count", product_count);
            session.setAttribute("tax", String.valueOf(tax));
            session.setAttribute("shipping", String.valueOf(shipping));
            // subtotal of all products, not one product
            session.setAttribute("subtotal", String.valueOf(subtotal));
            // total of all products
            session.setAttribute("total", String.valueOf(total));
            if(action == "checkout"){
                url = "/authorize_payment";
            }
            else {
                url = "/shopping_list.jsp";
            }

            sc.getRequestDispatcher(url).
                    forward(request, response);
        }
        catch(Exception e){
            url = "/login.jsp";
            sc.getRequestDispatcher(url).
                    forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

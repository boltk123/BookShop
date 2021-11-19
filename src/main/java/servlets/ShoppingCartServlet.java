package servlets;

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
        String action = request.getParameter("action");
        List<Books> books = BooksDB.selectBooksByUserID(1);
        List<Products> products = ProductsDB.getProductList(1);
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
            request.setAttribute("tax", String.valueOf(tax));
            request.setAttribute("shipping", String.valueOf(shipping));
            // subtotal of all products, not one product
            request.setAttribute("subtotal", String.valueOf(subtotal));
            // total of all products
            request.setAttribute("total", String.valueOf(total));
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request,response);
        }
        else {
            url = "/shopping_list.jsp";
        }

        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

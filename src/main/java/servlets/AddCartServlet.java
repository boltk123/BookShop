package servlets;

import business.Accounts;
import database.ProductsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCartServlet", value = "/AddCart")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        String url = "/ShoppingCart";
        try{
            Accounts current_account = (Accounts) session.getAttribute("account");
            int user_id = current_account.getUser_id();
            int book_id  = Integer.parseInt(request.getParameter("book_id"));
            if(ProductsDB.productExists(book_id, user_id) == false){
                ProductsDB.insertProduct(user_id, book_id);
            }
        }
        catch(Exception e){
            url = "/login.jsp";
        }

        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

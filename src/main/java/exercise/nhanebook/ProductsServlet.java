package exercise.nhanebook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String path = getServletContext().getRealPath("/WEB-INF/products.txt");
        ArrayList<Product> products = ProductIO.getProducts(path);
        session.setAttribute("products", products);

        String url = "/cart_exercise.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}

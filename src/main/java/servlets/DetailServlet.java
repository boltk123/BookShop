package servlets;

import business.Samples;
import database.ProductsDB;
import database.SamplesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/Detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();

        //int user_id = Integer.parseInt(request.getParameter("user_id"));
        int book_id = Integer.parseInt((request.getParameter("book_id")));
        List<Samples> samplesList = SamplesDB.selectAllSamples(book_id);

        String url = "/detail.jsp";
        sc.getRequestDispatcher(url).
                forward(request, response);
    }
}

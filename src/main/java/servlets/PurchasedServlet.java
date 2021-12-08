package servlets;

import business.Accounts;
import database.PurchasesDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchasedServlet", value = "/Purchased")
public class PurchasedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String url = "/FileDownload";
        HttpSession session = request.getSession();
        try {
            Accounts current_account = (Accounts)session.getAttribute("account");
            int book_id = Integer.parseInt(request.getParameter("book_id"));
            boolean purchased = PurchasesDB.purchased(current_account.getUser_id(), book_id);
            if (purchased != true) {
                url = "/AddCart";
            }
            else{
                url = "/FileDownload";
            }
        }
        catch (Exception e){
            url = "login.jsp";

        }
        request.getRequestDispatcher(url).forward(request, response);*/
        String url = "/FileDownload";
        HttpSession session = request.getSession();
            Accounts current_account = (Accounts)session.getAttribute("account");
            int book_id = Integer.parseInt(request.getParameter("book_id"));
            boolean purchased = PurchasesDB.purchased(current_account.getUser_id(), book_id);
            if (purchased != true) {
                url = "/AddCart";
            }
            else{
                url = "/FileDownload";
            }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

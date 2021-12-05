package servlets;

import business.Accounts;
import database.AccountsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountUpdateServlet", value = "/AccountUpdate")
public class AccountUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String url =" ";
        if (action.equals("update")){
            HttpSession session = request.getSession();

            String first_name = request.getParameter("firstname");
            String last_name = request.getParameter("lastname");

            Accounts account = (Accounts) session.getAttribute("account");

            account.setFirstName(first_name);
            account.setLastName(last_name);
            AccountsDB.update(account);

            session.setAttribute("account",account);
            url = "/accountinfo.jsp";
        }

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package servlets;

import business.Accounts;
import database.AccountsDB;
import database.BooksDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUserListServlet", value = "/AdminAccountList")
public class AdminAccountListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String url = "/admin-account.jsp";
        List<Accounts> accountsList = AccountsDB.selectAllAccount();
        request.setAttribute("accounts", accountsList);
        sc.getRequestDispatcher(url).
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

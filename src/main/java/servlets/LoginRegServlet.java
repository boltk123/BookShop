package servlets;

import business.Accounts;
import database.AccountsDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginRegServlet", value = "/LoginReg")
public class LoginRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/login.jsp";
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.equals("log_in")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String login_message = " ";
            String index_message = " " ;
            Accounts account = new Accounts();
            account.setUsername(username);
            account.setPassword(password);
            if (AccountsDB.accountExists(account.getUsername(), account.getPassword()) == false) {
                login_message = "Username or password doesn't exist";
                url = "/login.jsp";
            } else {
                account = AccountsDB.selectAccount(username, password);
                session.setAttribute("account", account);
                url = "/homepage.jsp";
                index_message = "Hello " + account.getUsername();
            }
            request.setAttribute("loginmessage", login_message);
            session.setAttribute("indexmessage", index_message);

        } else if (action.equals("register")) {
            url = "/register_final.jsp";
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String emailmessage = " ";
            String usernamemessage = " ";
            Accounts account = new Accounts();
            account.setFirstName(firstname);
            account.setLastName(lastname);
            account.setEmail(email);
            account.setUsername(username);
            account.setPassword(password);
            if (!AccountsDB.emailExists(account.getEmail()) && !AccountsDB.usernameExists(account.getUsername())) {
                url = "/thanks_final.jsp";
                session.setAttribute("account", account);
                AccountsDB.insert(account);
                String login_message = "Hello " + account.getUsername();
                session.setAttribute("loginmessage",login_message);
            } else {
                url = "/register_final.jsp";
                if (AccountsDB.emailExists(account.getEmail()))
                    emailmessage = "Email already exists";
                if (AccountsDB.usernameExists(account.getUsername()))
                    usernamemessage = "Username already exists";
            }
            request.setAttribute("emailmessage", emailmessage);
            request.setAttribute("usernamemessage", usernamemessage);
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

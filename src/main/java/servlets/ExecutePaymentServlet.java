/**
 * ExecutePaymentServlet class - execute payment via PayPal.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import business.Accounts;
import business.Products;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;
import database.PurchasesDB;
import features.paypal.PaymentServices;

@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecutePaymentServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");

		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);

			HttpSession session = request.getSession();
			List<Products> productsList = (List<Products>) session.getAttribute("products");
			Accounts current_account = (Accounts)session.getAttribute("account");
			PurchasesDB.insertInvoice(current_account.getUser_id(), productsList);
			// Store information to database
			request.getRequestDispatcher("receipt.jsp").forward(request, response);
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

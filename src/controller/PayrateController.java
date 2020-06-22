package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PayrateDAO;
import model.Payrate;
import utils.AuthUtil;

public class PayrateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PayrateController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		PayrateDAO payrateDAO = new PayrateDAO();
		List<Payrate> payRateList = payrateDAO.findAll();
		request.setAttribute("payRateList", payRateList);
		System.out.println(payRateList.size());
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/payroll/payrate/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

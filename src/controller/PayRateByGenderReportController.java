package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PayrateDAO;
import model.PayCondition;

public class PayRateByGenderReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	public PayRateByGenderReportController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PayrateDAO payrateDAO = new PayrateDAO();
		
		
		
		if(request.getParameter("con")!=null) {
			String con = request.getParameter("con");
			System.out.println(con);
			switch (con) {
			case "gender":
				List<PayCondition> payGenderList = payrateDAO.getSummaryPayByGender();
				request.setAttribute("payGenderList", payGenderList);
				System.out.println(payGenderList.size());
				break;
				
			case "dt":
				List<PayCondition> payDTList = payrateDAO.getSummaryPayByDT();
				request.setAttribute("payGenderList", payDTList);
				System.out.println(payDTList.size());
				break;
			
		case "department":
			List<PayCondition> payDepartmentList = payrateDAO.getSummaryPayByDepartMent();
			request.setAttribute("payGenderList", payDepartmentList);
			System.out.println(payDepartmentList.size());
			break;
		}
		}
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/report/pate_rate_bycondition.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

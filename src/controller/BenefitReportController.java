package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Benefit_PlanDAO;
import dao.PayrateDAO;
import dao.VacationDAO;
import model.BenefitReport;
import model.Payrate;
import model.VacationCondition;
import utils.AuthUtil;

public class BenefitReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BenefitReportController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		
		 Benefit_PlanDAO benefit_PlanDAO = new Benefit_PlanDAO();
		 List<BenefitReport> benReports = benefit_PlanDAO.getBenefitReport();
		 request.setAttribute("benReports", benReports);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/report/benefit.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

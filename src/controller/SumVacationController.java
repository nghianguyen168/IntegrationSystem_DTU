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
import dao.VacationDAO;
import model.Payrate;
import model.VacationCondition;
import utils.AuthUtil;

public class SumVacationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SumVacationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		 VacationDAO vacationDAO= new VacationDAO();
		 if(request.getParameter("con")!=null) {
			 String con =request.getParameter("con");
			 switch (con) {
			case "all":
				List<VacationCondition> vCondition = vacationDAO.getSumAll();
				request.setAttribute("vCondition", vCondition);
				break;
			case "gender":
				List<VacationCondition> vByGender = vacationDAO.getSumByGender();
				request.setAttribute("vCondition", vByGender);
				break;
			case "dt":
				List<VacationCondition> vByDT = vacationDAO.getSumBydt();
				request.setAttribute("vCondition", vByDT);
				break;	
			case "department":
				List<VacationCondition> vByDepartment = vacationDAO.getSumBydepartment();
				request.setAttribute("vCondition", vByDepartment);
				break;	
				
			}
		 }
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/report/sum_vacation.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

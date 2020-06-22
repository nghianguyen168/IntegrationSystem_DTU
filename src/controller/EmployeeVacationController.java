package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;
import utils.AuthUtil;

public class EmployeeVacationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeVacationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> outVacationList = employeeDAO.getOutVacation();
		
		request.setAttribute("outVacationList", outVacationList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/alert/vacation/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

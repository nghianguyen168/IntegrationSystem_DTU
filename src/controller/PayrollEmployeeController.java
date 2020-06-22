package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Employee_PayrollDAO;
import model.Employee_Payroll;
import utils.AuthUtil;


public class PayrollEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayrollEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		Employee_PayrollDAO employee_PayrollDAO = new Employee_PayrollDAO();
		List<Employee_Payroll> em_PayrollList = employee_PayrollDAO.findAll();
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/payroll/employee/index.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Benefit_PlanDAO;
import dao.Employee_PayrollDAO;
import dao.PersonalDAO;
import model.Employee_Payroll;
import model.Job_History;
import model.Personal;




public class DelEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public DelEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonalDAO pDao = new PersonalDAO();
		Employee_PayrollDAO employee_PayrollDAO = new Employee_PayrollDAO();
		
		String em_id =request.getParameter("id");
		int delHRM = pDao.delItem(em_id);
		int delPayroll = employee_PayrollDAO.delItem(em_id);
		
		if(delHRM>0 && delPayroll>0) {
			response.sendRedirect(request.getContextPath()+"/index?msg=delok");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/index?msg=delerror");
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		
	} 

}

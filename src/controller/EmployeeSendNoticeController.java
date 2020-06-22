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
import utils.DefineUtil;
import utils.SendMail;
import utils.StringUtil;

public class EmployeeSendNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeSendNoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		final String user = "nsklap2611@gmail.com";
		final String pass="maiyeu97";
		
		if(request.getParameter("function")!=null) {
			String function=request.getParameter("function");
			switch (function) {
			case "vacation":
				List<Employee> outVacationList = employeeDAO.getOutVacation();
				if(outVacationList.size()>0) {
				for(Employee employee:outVacationList) {
					if(!"".equals(employee.getCurrent_Personal_email())){
						String sub="Notification";
						String msg="Bạn đã nghỉ quá thời gian cho phép!";
						SendMail.send(employee.getCurrent_Personal_email(), sub, msg, user, pass);
					}
				}
			}
				response.sendRedirect(request.getContextPath()+"/alert/vacation?msg="+DefineUtil.SUCCESS);
				return;
			case "ani":
				List<Employee> hiringList = employeeDAO.getCurrentHiringAniList();
				System.out.println("size djfhdjs:"+hiringList.size());
				if(hiringList.size()>0) {
				for(Employee employee:hiringList) {
					if(!"".equals(employee.getCurrent_Personal_email())){
						String sub="Happy Anniversary";
						String msg="Happy Hiring Anniversary date,Wish you lots of health and success";
						SendMail.send(employee.getCurrent_Personal_email(), sub, msg, user, pass);
					}
					
				}
				
			}
				response.sendRedirect(request.getContextPath()+"/alert/hiring?msg="+DefineUtil.SUCCESS);
				return;
			case "birthday":
				List<Employee> birthdayList = employeeDAO.getCurentBirtdayList();
				System.out.println("size djfhdjs:"+birthdayList.size());
				if(birthdayList.size()>0) {
				for(Employee employee:birthdayList) {
					if(!"".equals(employee.getCurrent_Personal_email())){
						String sub="Happy Birthday for you";
						String msg="Happy Birthday,Wish you lots of health and success";
						SendMail.send(employee.getCurrent_Personal_email(), sub, msg, user, pass);
					}
					
				}
				
			}
				response.sendRedirect(request.getContextPath()+"/alert/birthday?msg="+DefineUtil.SUCCESS);
				return;
		

				
			}
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

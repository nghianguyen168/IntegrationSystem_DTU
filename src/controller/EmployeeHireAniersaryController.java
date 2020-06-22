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

public class EmployeeHireAniersaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeHireAniersaryController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> hiringAniList = employeeDAO.getHiringAniList();
		System.out.println(hiringAniList.size());
		request.setAttribute("hiringAniList", hiringAniList);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/alert/anniversary/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

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
import dao.PersonalDAO;
import model.Employee;
import model.Personal;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.SendMail;




public class EmployeeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public EmployeeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		String employeeName = (String)request.getParameter("employee");
		int status = Integer.parseInt(request.getParameter("status"));
		request.setAttribute("searchText", employeeName);
		
		System.out.println(employeeName);
		PersonalDAO personalDAO = new PersonalDAO();
		List<Personal> employeeSearch = personalDAO.search(employeeName,status);
		request.setAttribute("employeeSearch", employeeSearch);
		System.out.println("size nè:"+employeeSearch.size());
		
		request.setAttribute("employeeName", employeeName);
			
		if(employeeSearch.size()==0) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/public/index.jsp?result=no");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/public/index.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

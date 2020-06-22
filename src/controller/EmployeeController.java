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
import dao.RoleDAO;
import dao.UserDAO;
import model.Employee;
import model.Personal;
import model.Role;
import model.User;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.RandomPasswordUtils;
import utils.SendGmailUtil;
import utils.SendMail;
import utils.StringUtil;




public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		 RoleDAO roleDAO = new RoleDAO();
		 List<Role> roleList = roleDAO.roleList();
		 request.setAttribute("roleList", roleList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/user/add.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		int role_id = Integer.parseInt(request.getParameter("role") );
		String pass = RandomPasswordUtils.randomAlphaNumeric(6);
		String password = StringUtil.md5(pass);
		User user= new User(0, username, password, email, fullname, new Role(role_id, ""));
		User checkTrungUser = userDAO.checkTrung(username);
	
		if(checkTrungUser!=null) {
			User userTrung = new User(0, username, "", email, fullname, new Role(role_id, ""));
		
			request.setAttribute("userTrung", userTrung);
			RequestDispatcher rd = request.getRequestDispatcher("/views/public/user/add.jsp");
			rd.forward(request, response);
		}else {
			int addItem = userDAO.addItem(user);
			if(addItem>0) {
				String sub ="Successfully Sigup account Human And Payroll Management";
				String msg ="Your  account is:"
						+ "\n Username: "+username+""
						+ "\n Password: "+pass;
				SendGmailUtil.sendGmail(email, sub, msg);
			response.sendRedirect(request.getContextPath()+"/user?msg=success" );
			return;
		}
		
		}
		
	}

}

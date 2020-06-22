package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAO;
import dao.PersonalDAO;
import dao.UserDAO;
import model.Employee;
import model.Personal;
import model.User;
import utils.DefineUtil;
import utils.SendMail;
import utils.StringUtil;




public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/login.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String pass= request.getParameter("password");
		String password = StringUtil.md5(pass);
		UserDAO userDAO = new UserDAO();
		User userlogin = userDAO.checkLogin(username,password);
		
		if(userlogin!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogin", userlogin);
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		} else {
			User userFail = new User(username, pass);
			request.setAttribute("userFail", userFail);
			RequestDispatcher rd = request.getRequestDispatcher("/views/public/login.jsp?msg=fail");
			rd.forward(request, response);
		}
		
		
	}

}

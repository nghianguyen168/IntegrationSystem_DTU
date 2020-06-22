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




public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userLogin")!=null) {
			session.removeAttribute("userLogin");
			//RequestDispatcher rd = request.getRequestDispatcher("/views/admin/index.jsp");
			//rd.forward(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}

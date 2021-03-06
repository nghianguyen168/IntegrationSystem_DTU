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




public class EmployeeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public EmployeeEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/user/add.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}

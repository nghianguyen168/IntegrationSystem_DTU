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




public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public HomePageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		PersonalDAO personalDAO = new PersonalDAO();
		List<Personal> pList = personalDAO.findAll();
		System.out.println("sn ne:"+pList.get(0).getBIRTH_DATE());
		
		  int numberOfItems = personalDAO.findAll().size(); 
		  System.out.println("jdfh"+numberOfItems);
		  int numberOfPages = (int)(numberOfItems/DefineUtil.NUMBER_PER_PAGE);
		  if(numberOfPages*DefineUtil.NUMBER_PER_PAGE<personalDAO.findAll().size()) {
		  numberOfPages+=1; }
		  int curentPage=1;
		  if(request.getParameter("page")!=null) {
			  curentPage = Integer.parseInt(request.getParameter("page"));
		  }
		
		  System.out.println("Trang hiện tại:"+curentPage);
		  if(curentPage>numberOfPages || curentPage<1) { 
			  curentPage=1; } 
		  int offset =(curentPage - 1)* DefineUtil.NUMBER_PER_PAGE;
		  List<Personal> pListByAdmin = personalDAO.findAllByPage(offset);
			System.out.println(pListByAdmin.size());
		request.setAttribute("pListByAdmin", pListByAdmin);
		request.setAttribute("offset", offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("curentPage", curentPage);
		request.setAttribute("numberOfItems", numberOfItems);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

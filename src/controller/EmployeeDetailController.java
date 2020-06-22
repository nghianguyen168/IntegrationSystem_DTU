package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Benefit_PlanDAO;
import dao.EmployeeDAO;
import dao.Job_HistoryDAO;
import dao.PayrateDAO;
import dao.PersonalDAO;
import model.Benefit_Plan;
import model.Employee;
import model.Job_History;
import model.Payrate;
import model.Personal;
import utils.AuthUtil;
import utils.DefineUtil;
import utils.SendMail;




public class EmployeeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public EmployeeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(!AuthUtil.checkLogin(request, response)) {
			   response.sendRedirect(request.getContextPath()+"/login");
			   return;
		   }
		PersonalDAO personalDAO = new PersonalDAO();
		Job_HistoryDAO job_HistoryDAO = new Job_HistoryDAO();
		String em_Id = request.getParameter("id");
		List<Job_History> job_HistorieList = job_HistoryDAO.findALL(em_Id);
		System.out.println(job_HistorieList.size());
		request.setAttribute("job_HistorieList", job_HistorieList);
		Personal personal = personalDAO.getItemById(em_Id);
		request.setAttribute("personal", personal);
		PayrateDAO payrateDAO = new PayrateDAO();
		Payrate payrate = payrateDAO.getPayRateEmployee(em_Id);
		request.setAttribute("payrate", payrate);
		System.out.println("pay rate:"+payrate);
		System.out.println(personal);
		Benefit_PlanDAO benefit_PlanDAO = new Benefit_PlanDAO();
		Benefit_Plan benefit_Plan = benefit_PlanDAO.getBenefit_Plan(em_Id);
		request.setAttribute("benefit_Plan", benefit_Plan);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/infomation/employee/detail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

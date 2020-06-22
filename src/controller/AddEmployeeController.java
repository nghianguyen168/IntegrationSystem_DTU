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




public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int check_send=0;
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Benefit_PlanDAO benDao=new Benefit_PlanDAO();
		System.out.println("ben size"+benDao.findAll().size());
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/infomation/employee/add.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String em_Id = request.getParameter("emid");
		String first_name = request.getParameter("firstname");
		String midle_name = request.getParameter("midlename");
		String last_name = request.getParameter("lastname");
		String adress = request.getParameter("adress");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		Date birthday = Date.valueOf(request.getParameter("birthday"));
		String department = request.getParameter("department");
		String division = request.getParameter("division");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String dantoc = request.getParameter("dantoc");
		int sh_status = Integer.parseInt(request.getParameter("sh"));
		int benefit = Integer.parseInt(request.getParameter("benefit"));
				
				
	
		PersonalDAO personalDAO = new PersonalDAO();
		Employee_PayrollDAO employee_PayrollDAO = new Employee_PayrollDAO();
		
		
		Personal personal = new Personal(0, em_Id, first_name, last_name, midle_name, birthday,adress,city, country,  phone,gender,email,sh_status,dantoc,benefit);
		Job_History job_History = new Job_History(0, em_Id, department, division, new java.util.Date(), null, "", "", "", "");
		Employee_Payroll employee_Payroll = new Employee_Payroll(em_Id, 0, last_name, first_name, midle_name);
		
	
		Employee_Payroll checkTrung = employee_PayrollDAO.checkTrung(em_Id);
		if(checkTrung==null) {
			int addPersonal = personalDAO.addItem(personal,job_History);
			int addEmToPayroll = employee_PayrollDAO.addItem(employee_Payroll);
			if(addPersonal>0 && addEmToPayroll>0) {
				response.sendRedirect(request.getContextPath()+"/index?msg=success");
				return;
			} }else {
				request.setAttribute("personal", personal);
				request.setAttribute("job_History",job_History );
				request.setAttribute("employee_Payroll", employee_Payroll);
				RequestDispatcher rd = request.getRequestDispatcher("/views/public/infomation/employee/add.jsp?msg=trung");
				rd.forward(request, response);
				
			
		}
		
		
		
	} 

}

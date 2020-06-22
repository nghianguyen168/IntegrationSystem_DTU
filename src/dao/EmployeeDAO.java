package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Benefit_Plan;
import model.Employee;
import utils.DBConnectionUtil;

public class EmployeeDAO {
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	Connection conn;
	public List<Employee> getBirtdayList() {
		List<Employee> birtDayList = new ArrayList<Employee>();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		final String sql ="SELECT * FROM PERSONAL WHERE MONTH(BIRTH_DATE) = ?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, month);
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("CURRENT_FIRST_NAME"), rs.getString("CURRENT_LAST_NAME"), rs.getString("CURRENT_MIDDLE_NAME"),
						rs.getDate("BIRTH_DATE"), rs.getString("SOCIAL_SECURITY_NUMBER"), rs.getString("DRIVERS_LICENSE"), rs.getString("CURRENT_ADDRESS_1"),
						rs.getString("CURRENT_ADDRESS_2"), rs.getString("CURRENT_CITY"), 
						rs.getString("CURRENT_COUNTRY"), rs.getString("CURRENT_ZIP"), rs.getString("CURRENT_GENDER"), rs.getString("CURRENT_PHONE_NUMBER"), rs.getString("CURRENT_PERSONAL_EMAIL"),
						rs.getString("CURRENT_MARITAL_STATUS"), rs.getString("ETHNICITY"), rs.getInt("BENEFIT_PLAN_ID"));
				birtDayList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return birtDayList;
	}
	public List<Employee> getCurentBirtdayList() {
		List<Employee> birtDayList = new ArrayList<Employee>();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		final String sql ="SELECT * FROM PERSONAL WHERE MONTH(BIRTH_DATE) = ? AND DAY(BIRTH_DATE)=?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, month);
			pst.setInt(2,day );
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("CURRENT_FIRST_NAME"), rs.getString("CURRENT_LAST_NAME"), rs.getString("CURRENT_MIDDLE_NAME"),
						rs.getDate("BIRTH_DATE"), rs.getString("SOCIAL_SECURITY_NUMBER"), rs.getString("DRIVERS_LICENSE"), rs.getString("CURRENT_ADDRESS_1"),
						rs.getString("CURRENT_ADDRESS_2"), rs.getString("CURRENT_CITY"), 
						rs.getString("CURRENT_COUNTRY"), rs.getString("CURRENT_ZIP"), rs.getString("CURRENT_GENDER"), rs.getString("CURRENT_PHONE_NUMBER"), rs.getString("CURRENT_PERSONAL_EMAIL"),
						rs.getString("CURRENT_MARITAL_STATUS"), rs.getString("ETHNICITY"), rs.getInt("BENEFIT_PLAN_ID"));
				birtDayList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return birtDayList;
	}
	public List<Employee> getOutVacation(){
		List<Employee> outVacationList = new ArrayList<Employee>();
		final String sql="SELECT p.EMPLOYEE_ID As employee_ID,p.CURRENT_FIRST_NAME AS first_Name,p.CURRENT_MIDDLE_NAME AS current_Middle_Name,p.CURRENT_LAST_NAME AS lase_Name,p.CURRENT_PERSONAL_EMAIL, j.DEPARTMENT AS department,ek.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH AS num_of_vacation FROM PERSONAL AS p INNER JOIN \r\n" + 
				"JOB_HISTORY AS j ON p.EMPLOYEE_ID=j.EMPLOYMENT_ID\r\n" + 
				"INNER JOIN EMPLOYMENT AS em ON p.EMPLOYEE_ID=em.EMPLOYMENT_ID\r\n" + 
				" INNER JOIN EMPLOYMENT_WORKING_TIME AS ek ON p.EMPLOYEE_ID=ek.EMPLOYMENT_ID WHERE ek.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH >3 ";
		conn=DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Employee employee = new Employee(rs.getString("employee_ID"), rs.getString("first_Name"), rs.getString("lase_Name"), rs.getString("current_Middle_Name"),rs.getString("CURRENT_PERSONAL_EMAIL"), rs.getInt("num_of_vacation"),rs.getString("department"));
				outVacationList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return outVacationList;
		
	}
	
	public static void main(String[] args) {
		/*
		 * Date date = new Date(); SimpleDateFormat format = new
		 * SimpleDateFormat("dd/MM/yyyy"); String date_after = format.format(date);
		 * System.out.println(date_after); System.out.println(new
		 * EmployeeDAO().getBirtdayList());
		 */
		System.out.println(new EmployeeDAO().getEmBenefitList());
	}
	public List<Employee> getHiringAniList() {
		List<Employee> hirringList = new ArrayList<Employee>();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		final String sql ="SELECT p.EMPLOYEE_ID AS employee_ID,p.CURRENT_FIRST_NAME AS first_name,p.CURRENT_MIDDLE_NAME AS current_Middle_Name ,p.CURRENT_LAST_NAME AS lase_Name, j.DEPARTMENT  AS department,em.HIRE_DATE_FOR_WORKING AS hiringDate FROM PERSONAL AS p INNER JOIN \r\n" + 
				"JOB_HISTORY AS j ON p.EMPLOYEE_ID=j.EMPLOYMENT_ID\r\n" + 
				"INNER JOIN EMPLOYMENT AS em ON p.EMPLOYEE_ID=em.EMPLOYMENT_ID\r\n" + 
				" INNER JOIN EMPLOYMENT_WORKING_TIME AS ek ON p.EMPLOYEE_ID=ek.EMPLOYMENT_ID  WHERE MONTH(em.HIRE_DATE_FOR_WORKING) = ? ORDER BY DAY(em.HIRE_DATE_FOR_WORKING)";
		
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, month);
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(rs.getString("employee_ID"), rs.getString("first_Name"), rs.getString("lase_Name"), rs.getString("current_Middle_Name"), rs.getString("department"), rs.getDate("hiringDate"));
				hirringList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hirringList;
	}
	public List<Employee> getCurrentHiringAniList() {
		List<Employee> hirringList = new ArrayList<Employee>();
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		final String sql ="SELECT p.EMPLOYEE_ID AS employee_ID,p.CURRENT_FIRST_NAME AS first_name,p.CURRENT_MIDDLE_NAME AS current_Middle_Name ,p.CURRENT_LAST_NAME AS lase_Name,p.CURRENT_PERSONAL_EMAIL AS email, j.DEPARTMENT  AS department,em.HIRE_DATE_FOR_WORKING AS hiringDate FROM PERSONAL AS p INNER JOIN \r\n" + 
				"JOB_HISTORY AS j ON p.EMPLOYEE_ID=j.EMPLOYMENT_ID\r\n" + 
				"INNER JOIN EMPLOYMENT AS em ON p.EMPLOYEE_ID=em.EMPLOYMENT_ID\r\n" + 
				" INNER JOIN EMPLOYMENT_WORKING_TIME AS ek ON p.EMPLOYEE_ID=ek.EMPLOYMENT_ID WHERE MONTH(em.HIRE_DATE_FOR_WORKING) = ? AND DAY(em.HIRE_DATE_FOR_WORKING) = ?";
		
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, month);
			pst.setInt(2, day);
			rs = pst.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(rs.getString("employee_ID"), rs.getString("first_Name"), rs.getString("lase_Name"), rs.getString("current_Middle_Name"), rs.getString("department"),rs.getString("email"), rs.getDate("hiringDate"));
				hirringList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hirringList;
	}
	public List<Employee> getEmBenefitList() {
		List<Employee> emBenefitList  = new ArrayList<Employee>();
		final String sql ="SELECT p.EMPLOYEE_ID AS employee_ID,p.CURRENT_FIRST_NAME  AS first_name,p.CURRENT_MIDDLE_NAME AS current_Middle_Name,p.CURRENT_LAST_NAME AS lase_Name,b.PLAN_NAME AS plan_Name,b.DEDUCTABLE AS deductable,b.PERCENTAGE_COPAY AS percentage_Copay FROM PERSONAL AS p INNER JOIN BENEFIT_PLANS AS b\r\n" + 
				"ON p.BENEFIT_PLAN_ID = b.BENEFIT_PLANS_ID";
	conn = DBConnectionUtil.sqlConnection();
	try {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			Employee employee = new  Employee(rs.getString("employee_ID"), rs.getString("first_Name"), rs.getString("lase_Name"), rs.getString("current_Middle_Name"), new Benefit_Plan(0, rs.getString("plan_Name"), rs.getInt("deductable"), rs.getInt("percentage_Copay")));
			emBenefitList.add(employee);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return emBenefitList;
	}
	
	
	
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Employee_Working;
import model.Job_History;
import model.Personal;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class PersonalDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	public List<Personal> findAll() {
		List<Personal> pList= new  ArrayList<Personal>();
		final String sql ="SELECT * FROM  PERSONAL ORDER BY PERSONAL_ID DESC";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Personal personal = new Personal(rs.getInt("PERSONAL_ID"), rs.getString("EMPLOYEE_ID"), rs.getString("CURRENT_FIRST_NAME"), rs.getString("CURRENT_LAST_NAME"), rs.getString("CURRENT_MIDDLE_NAME"), rs.getDate("BIRTH_DATE"), rs.getString("CURRENT_COUNTRY"), rs.getString("CURRENT_PHONE_NUMBER"), rs.getString("CURRENT_GENDER"), rs.getString("CURRENT_PERSONAL_EMAIL"));
				pList.add(personal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		
		return pList;
	}
	public List<Personal> findAllByPage(int offset) {
		List<Personal> pList= new  ArrayList<Personal>();
		final String sql ="SELECT * FROM( SELECT *, ROW_NUMBER() OVER (ORDER BY EMPLOYEE_ID) as row FROM PERSONAl AS P INNER JOIN JOB_HISTORY AS J ON P.EMPLOYEE_ID=J.EMPLOYMENT_ID  ) a WHERE row > ? and row <= ?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, offset+DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()) {
				Personal personal = new Personal(rs.getInt("PERSONAL_ID"), rs.getString("EMPLOYEE_ID"), rs.getString("CURRENT_FIRST_NAME"), rs.getString("CURRENT_LAST_NAME"), rs.getString("CURRENT_MIDDLE_NAME"), rs.getDate("BIRTH_DATE"), rs.getString("CURRENT_COUNTRY"), rs.getString("CURRENT_PHONE_NUMBER"), rs.getString("CURRENT_GENDER"), rs.getString("CURRENT_PERSONAL_EMAIL"),rs.getString("DEPARTMENT"),rs.getString("DIVISION"));
				pList.add(personal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		
		return pList;
	}
	public Personal getItemById(String em_Id) {
		Personal personal = null;
		final String sql ="SELECT P.*,E.*,EW.* FROM PERSONAL AS P INNER JOIN EMPLOYMENT AS E on P.EMPLOYEE_ID=E.EMPLOYMENT_ID INNER JOIN EMPLOYMENT_WORKING_TIME AS EW \r\n" + 
				"ON P.EMPLOYEE_ID = EW.EMPLOYMENT_ID WHERE p.EMPLOYEE_ID =?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_Id);
			rs = pst.executeQuery();
			if(rs.next()) {
				personal = new Personal(rs.getInt("pERSONAL_ID"), rs.getString("eMPLOYEE_ID"), rs.getString("cURRENT_FIRST_NAME"), rs.getString("cURRENT_LAST_NAME"),
						rs.getString("cURRENT_MIDDLE_NAME"), rs.getDate("bIRTH_DATE"),rs.getString("cURRENT_ADDRESS_1"),rs.getString("cURRENT_CITY"), rs.getString("cURRENT_COUNTRY"), 
						rs.getString("cURRENT_PHONE_NUMBER"), rs.getString("cURRENT_GENDER"), rs.getString("cURRENT_PERSONAL_EMAIL"),
						new Employee_Working(rs.getString("eMPLOYMENT_ID"), rs.getDate("hIRE_DATE_FOR_WORKING"), rs.getString("wORKERS_COMP_CODE"), 
								rs.getDate("tERMINATION_DATE"), rs.getDate("rEHIRE_DATE_FOR_WORKING"), rs.getDate("lAST_REVIEW_DATE"), rs.getInt("nUMBER_DAYS_REQUIREMENT_OF_WORKING_PER_MONTH"), 
								rs.getInt("nUMBER_DAYS_ACTUAL_OF_WORKING_PER_MONTH"), rs.getInt("tOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return personal;
	}
	public List<Personal> search(String employeeName,int status) {
		List<Personal> emListSearch = new ArrayList<Personal>();
		 String sql= "SELECT *  FROM PERSONAL AS P INNER JOIN JOB_HISTORY AS L ON P.EMPLOYEE_ID=L.EMPLOYMENT_ID WHERE 1=1 ";
		conn = DBConnectionUtil.sqlConnection();
		
		if(!"".equals(employeeName)) {
			sql+= "CONCAT(CURRENT_FIRST_NAME+' ',CURRENT_MIDDLE_NAME+' ',CURRENT_LAST_NAME) LIKE ? ";
		}
		if(status==0 || status==1) {
			sql+="AND SHAREHOLDER_STATUS="+status;
		}
		try {
			pst = conn.prepareStatement(sql);
			if(!"".equals(employeeName)) {
				pst.setString(1, "%"+employeeName+"%");
			}
			rs = pst.executeQuery();
			while(rs.next()) {
				Personal personal = new Personal(rs.getInt("PERSONAL_ID"), rs.getString("EMPLOYEE_ID"), rs.getString("CURRENT_FIRST_NAME"), rs.getString("CURRENT_LAST_NAME"), rs.getString("CURRENT_MIDDLE_NAME"), rs.getDate("BIRTH_DATE"), rs.getString("CURRENT_COUNTRY"), rs.getString("CURRENT_PHONE_NUMBER"), rs.getString("CURRENT_GENDER"), rs.getString("CURRENT_PERSONAL_EMAIL"),rs.getString("DEPARTMENT"),rs.getString("DIVISION"));
				emListSearch.add(personal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emListSearch;
	}
	public int addItem(Personal personal,Job_History job_History) {
		int result = 0;
		final String sql="INSERT INTO EMPLOYMENT(EMPLOYMENT_ID)\r\n" + 
				"VALUES(?)\r\n" + 
				"\r\n" + 
				"INSERT INTO EMPLOYMENT_WORKING_TIME(EMPLOYMENT_ID)\r\n" + 
				"VALUES(?)\r\n" + 
				"INSERT INTO PERSONAL(EMPLOYEE_ID,CURRENT_FIRST_NAME,CURRENT_MIDDLE_NAME,CURRENT_LAST_NAME,BIRTH_DATE,CURRENT_ADDRESS_1,CURRENT_CITY,CURRENT_COUNTRY,CURRENT_GENDER,CURRENT_PHONE_NUMBER,CURRENT_PERSONAL_EMAIL,ETHNICITY,BENEFIT_PLAN_ID)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)\r\n" + 
				"\r\n" + 
				"INSERT INTO JOB_HISTORY(EMPLOYMENT_ID,DEPARTMENT,DIVISION)\r\n" + 
				"VALUES(?,?,?)";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,personal.getEMPLOYEE_ID());
			pst.setString(2,personal.getEMPLOYEE_ID());
			pst.setString(3,personal.getEMPLOYEE_ID());
			pst.setString(4,personal.getCURRENT_FIRST_NAME());
			pst.setString(5,personal.getCURRENT_MIDDLE_NAME());
			pst.setString(6,personal.getCURRENT_LAST_NAME());
			pst.setDate(7,(Date) personal.getBIRTH_DATE());
			pst.setString(8,personal.getCURRENT_ADDRESS_1());
			pst.setString(9,personal.getCURRENT_CITY());
			pst.setString(10,personal.getCURRENT_COUNTRY());
			pst.setString(11,personal.getCURRENT_GENDER());
			pst.setString(12,personal.getCURRENT_PHONE_NUMBER());
			pst.setString(13,personal.getCURRENT_PERSONAL_EMAIL());
			pst.setString(14,personal.getETHNICITY());
			pst.setInt(15,personal.getBENEFIT_PLANS());
			pst.setString(16,personal.getEMPLOYEE_ID());
			pst.setString(17,job_History.getDEPARTMENT());
			pst.setString(18,job_History.getDIVISION());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return result;
	}
	public int delItem(String em_id) {
		int result = 0;
		final String sql ="DELETE FROM PERSONAL WHERE EMPLOYEE_ID=? \r\n" + 
				"DELETE FROM EMPLOYMENT WHERE EMPLOYMENT_ID=? \r\n" + 
				"DELETE FROM EMPLOYMENT_WORKING_TIME WHERE EMPLOYMENT_ID=?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_id);
			pst.setString(2, em_id);
			pst.setString(3, em_id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return result;
	}
	
	
}

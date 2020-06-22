package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PayCondition;
import model.VacationCondition;
import utils.DBConnectionUtil;

public class VacationDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	
	public List<VacationCondition> getSumAll() {
		List<VacationCondition>  vacationCondition= new ArrayList<VacationCondition>();
		final String sql="SELECT SUM(EW.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH) AS value FROM PERSONAL AS P INNER JOIN EMPLOYMENT_WORKING_TIME AS EW ON P.EMPLOYEE_ID= EW.EMPLOYMENT_ID ";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				VacationCondition vCondition = new VacationCondition("Sum All", rs.getInt("value"));
				vacationCondition.add(vCondition);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return vacationCondition;
	
	}
	
	public List<VacationCondition> getSumByGender() {
		List<VacationCondition>  vacationCondition= new ArrayList<VacationCondition>();
		final String sql="SELECT P.CURRENT_GENDER AS name,SUM(EW.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH) AS value FROM PERSONAL AS P INNER JOIN EMPLOYMENT_WORKING_TIME AS EW ON P.EMPLOYEE_ID= EW.EMPLOYMENT_ID GROUP BY P.CURRENT_GENDER";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				VacationCondition vCondition = new VacationCondition(rs.getString("name"), rs.getInt("value"));
				vacationCondition.add(vCondition);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return vacationCondition;
	
	}
	
	public List<VacationCondition> getSumBydt() {
		List<VacationCondition>  vacationCondition= new ArrayList<VacationCondition>();
		final String sql="SELECT P.ETHNICITY AS name,SUM(EW.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH) AS value  FROM PERSONAL AS P INNER JOIN EMPLOYMENT_WORKING_TIME AS EW ON P.EMPLOYEE_ID= EW.EMPLOYMENT_ID GROUP BY P.ETHNICITY";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				VacationCondition vCondition = new VacationCondition(rs.getString("name"), rs.getInt("value"));
				vacationCondition.add(vCondition);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return vacationCondition;
	
	}
	
	public List<VacationCondition> getSumBydepartment() {
		List<VacationCondition>  vacationCondition= new ArrayList<VacationCondition>();
		final String sql="SELECT J.DEPARTMENT AS name,SUM(EW.TOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH) AS value FROM JOB_HISTORY AS J INNER JOIN EMPLOYMENT_WORKING_TIME AS EW ON J.EMPLOYMENT_ID= EW.EMPLOYMENT_ID GROUP BY J.DEPARTMENT";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				VacationCondition vCondition = new VacationCondition(rs.getString("name"), rs.getInt("value"));
				vacationCondition.add(vCondition);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return vacationCondition;
	
	}
	
	
}

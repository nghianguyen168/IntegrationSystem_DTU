package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee_Payroll;
import utils.DBConnectionUtil;

public class Employee_PayrollDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	public List<Employee_Payroll> findAll() {
		List<Employee_Payroll> em_PayrollList = new ArrayList<Employee_Payroll>();
		final String SQL ="SELECT * FROM pay_rates";
		conn = DBConnectionUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				Employee_Payroll employee_Payroll = new Employee_Payroll(rs.getString("idEmployee" ), rs.getInt("employee_Number"),
						rs.getString("last_Name"), rs.getString("first_Name"), rs.getInt("sSN"),
						rs.getString("pay_Rate"), rs.getInt("pay_Rate_idPay_Rate"), rs.getInt("vacation_Days"), rs.getInt("paid_To_Day"),
						rs.getInt("paid_Last_Year"));
				em_PayrollList.add(employee_Payroll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em_PayrollList;
	}
	public int addItem(Employee_Payroll employee_Payroll) {
		int result=0;
		final String sql = "INSERT INTO employee(idEmployee,Last_Name,First_Name,Midle_name) VALUES (?,?,?,?)";
		conn = DBConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, employee_Payroll.getIdEmployee());
			pst.setString(2, employee_Payroll.getLast_Name());
			pst.setString(3, employee_Payroll.getFirst_Name());
			pst.setString(4, employee_Payroll.getMidle_Name());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst);
		}
		return result;
	}
	public Employee_Payroll checkTrung(String em_Id) {
		Employee_Payroll emPayroll=null;
		final String sql="SELECT * FROM employee WHERE idEmployee=? ";
		conn = DBConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_Id);
			rs = pst.executeQuery();
			if(rs.next()) {
				emPayroll = new Employee_Payroll(rs.getString("idEmployee"), 0, rs.getString("last_Name"), rs.getString("first_Name"), rs.getString("midle_Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emPayroll;
	}
	public int delItem(String em_id) {
		int result = 0;
		final String sql ="DELETE FROM employee WHERE idEmployee=?";
				
		conn = DBConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_id);
			
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

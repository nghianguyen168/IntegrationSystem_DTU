package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PayCondition;
import model.Payrate;
import utils.DBConnectionUtil;

public class PayrateDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	public List<Payrate> findAll() {
		List<Payrate> payrateList = new ArrayList<Payrate>();
		final String sql = "SELECT * FROM pay_rates";
		conn = DBConnectionUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Payrate payrate = new Payrate(rs.getInt("idPay_Rates"), rs.getString("Pay_Rate_Name"), rs.getInt("Value"), rs.getInt("Tax_Percentage"),
						rs.getInt("Pay_Type"), rs.getInt("Pay_Amount"), rs.getInt("PT_Level_C"));
				payrateList.add(payrate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);;
		}
	
		return payrateList;
	}
	
	public Payrate getPayRateEmployee(String em_Id) {
		Payrate payrate = null;
		final String sql = "SELECT em.*,p.* FROM employee AS em INNER JOIN pay_rates as p ON em.Pay_Rates_idPay_Rates = p.idPay_Rates WHERE  em.idEmployee=? ";
		conn = DBConnectionUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_Id);
			rs = pst.executeQuery();
			if(rs.next()) {
				payrate = new Payrate(rs.getString("idEmployee"), rs.getInt("idPay_Rates"),rs.getString("pay_Rate_Name") , rs.getInt("value"), rs.getInt("tax_Percentage"), rs.getInt("pay_Type"),
						rs.getInt("pay_Amount"), rs.getInt("pt_Level_C"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return payrate;
	}
	
	public int getSummaryPay() {
		int sum=0;
		final String sql="SELECT * \r\n" + 
				"INTO #Temp_Products\r\n" + 
				"FROM OPENQUERY([MySQL], 'SELECT em.*,p.* FROM employee AS em INNER JOIN pay_rates as p ON em.Pay_Rates_idPay_Rates = p.idPay_Rates')\r\n" + 
				"SELECT sum(A.Pay_amount ) AS sum  FROM #TEMP_PRODUCTS AS A\r\n" + 
				"INNER JOIN PERSONAL AS B\r\n" + 
				"ON A.idEmployee = B.EMPLOYEE_ID ";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				sum = rs.getInt("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		System.out.println(sum);
		return sum;
	}

	public List getSummaryPayByGender() {
		List<PayCondition> payByCondition = new ArrayList<PayCondition>();
		final String sql="SELECT * \r\n" + 
				"INTO #Temp_Products\r\n" + 
				"FROM OPENQUERY([MySQL], 'SELECT em.*,p.* FROM employee AS em INNER JOIN pay_rates as p ON em.Pay_Rates_idPay_Rates = p.idPay_Rates')\r\n" + 
				"SELECT B.CURRENT_GENDER AS gender,SUM(A.Pay_Amount) AS value  FROM #TEMP_PRODUCTS AS A\r\n" + 
				"INNER JOIN PERSONAL AS B\r\n" + 
				"ON A.idEmployee = B.EMPLOYEE_ID  GROUP BY  B.CURRENT_GENDER";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PayCondition payGender = new PayCondition(rs.getString("gender"), rs.getInt("value"));
				payByCondition.add(payGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return payByCondition;
	}
	
	public List getSummaryPayByDT() {
		List<PayCondition> payByGender = new ArrayList<PayCondition>();
		final String sql="SELECT * \r\n" + 
				"INTO #Temp_Products\r\n" + 
				"FROM OPENQUERY([MySQL], 'SELECT em.*,p.* FROM employee AS em INNER JOIN pay_rates as p ON em.Pay_Rates_idPay_Rates = p.idPay_Rates')\r\n" + 
				"SELECT B.ETHNICITY AS dantoc,SUM(A.Pay_Amount) AS value  FROM #TEMP_PRODUCTS AS A\r\n" + 
				"INNER JOIN PERSONAL AS B\r\n" + 
				"ON A.idEmployee = B.EMPLOYEE_ID  GROUP BY  B.ETHNICITY";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PayCondition payGender = new PayCondition(rs.getString("dantoc"), rs.getInt("value"));
				payByGender.add(payGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return payByGender;
	}
	
	public List getSummaryPayByDepartMent() {
		List<PayCondition> payByGender = new ArrayList<PayCondition>();
		final String sql="SELECT * INTO #Temp_Products FROM OPENQUERY([MySQL], 'SELECT em.*,p.* FROM employee AS em INNER JOIN pay_rates as p ON em.Pay_Rates_idPay_Rates = p.idPay_Rates')\r\n" + 
				"	SELECT B.DEPARTMENT AS dantoc,SUM(A.Pay_Amount) AS value  FROM #TEMP_PRODUCTS AS A INNER JOIN JOB_HISTORY AS B ON A.idEmployee = B.EMPLOYMENT_ID  GROUP BY  B.DEPARTMENT\r\n" + 
				"	";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				PayCondition payGender = new PayCondition(rs.getString("dantoc"), rs.getInt("value"));
				payByGender.add(payGender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return payByGender;
	}
	
	
}

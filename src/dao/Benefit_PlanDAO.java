package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BenefitReport;
import model.Benefit_Plan;
import model.VacationCondition;
import utils.DBConnectionUtil;

public class Benefit_PlanDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	
	public Benefit_Plan getBenefit_Plan(String emId) {
		Benefit_Plan benefit_Plan =null;
		final String sql="SELECT B.* FROM PERSONAL AS P INNER JOIN BENEFIT_PLANS AS B ON P.BENEFIT_PLAN_ID = B.BENEFIT_PLANS_ID WHERE P.EMPLOYEE_ID=?";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emId);
			rs = pst.executeQuery();
			if(rs.next()) {
				benefit_Plan = new Benefit_Plan(rs.getInt("BENEFIT_PLANS_ID"),rs.getString("PLAN_NAME"), rs.getInt("DEDUCTABLE"),  rs.getInt("PERCENTAGE_COPAY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
			return benefit_Plan;	
	}
	public List<Benefit_Plan> findAll(){
		List<Benefit_Plan> benList = new ArrayList<Benefit_Plan>();
		final String sql="SELECT * FROM BENEFIT_PLANS ";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Benefit_Plan benefit_Plan = new Benefit_Plan(rs.getInt("BENEFIT_PLANS_ID"), rs.getString("plan_Name"), rs.getInt("deductable"), rs.getInt("percentage_Copay"));
				benList.add(benefit_Plan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return benList;
	}
	
	public List<BenefitReport> getBenefitReport(){
		
				List<BenefitReport>  bReport= new ArrayList<BenefitReport>();
		final String sql="SELECT P.SHAREHOLDER_STATUS AS status ,SUM(B.DEDUCTABLE) AS value  FROM PERSONAL AS P INNER JOIN BENEFIT_PLANS AS B ON P.BENEFIT_PLAN_ID= B.BENEFIT_PLANS_ID GROUP BY P.SHAREHOLDER_STATUS";
		conn = DBConnectionUtil.sqlConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BenefitReport vCondition = new BenefitReport(rs.getInt("status"), rs.getInt("value"));
				bReport.add(vCondition);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnectionUtil.close(conn, pst);
		}
		
		return bReport;
	
	
	}
}

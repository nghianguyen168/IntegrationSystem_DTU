package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Job_History;
import utils.DBConnectionUtil;

public class Job_HistoryDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	public List<Job_History> findALL(String em_Id) {
		List<Job_History> jList = new ArrayList<Job_History>();
		final String sql ="SELECT * FROM JOB_HISTORY  WHERE EMPLOYMENT_ID =? ORDER BY JOB_HISTORY_ID DESC";
		conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, em_Id);
			rs = pst.executeQuery();
			while(rs.next()) {
				Job_History job_History = new Job_History(rs.getInt("jOB_HISTORY_ID"), rs.getString("eMPLOYMENT_ID"), rs.getString("dEPARTMENT"), rs.getString("dIVISION"), 
						rs.getDate("fROM_DATE"), rs.getDate("tHRU_DATE"), rs.getString("jOB_TITLE"), rs.getString("sUPERVISOR"), rs.getString("lOCATION"), rs.getString("tYPE_OF_WORK"));
				jList.add(job_History);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jList;
	}
	
}

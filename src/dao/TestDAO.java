package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import utils.DBConnectionUtil;

public class TestDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public int addItem() {
		int result=0;
		final String sql="INSERT INTO guest(username,password) VALUES('nghia','123')";
		Connection conn = DBConnectionUtil.sqlConnection();
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		TestDAO testDAO = new TestDAO();
		testDAO.addItem();
	}
	 
	
}

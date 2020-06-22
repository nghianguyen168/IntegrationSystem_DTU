package utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;

public class DBConnectionUtil {
	private static  String URL;
	private static  String USER;
	private static  String PASSWORD;
	
	
	public static Connection getConnection() {
		Connection conn= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		 try {
			 Properties properties = PropertiesUtil.readProperties();
			 URL = properties.getProperty("url");
			 USER= properties.getProperty("user");
			 PASSWORD = properties.getProperty("password");
			 conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	};
	
	public static Connection hrmUserConnection() {
		Connection conn= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		 try {
			 
			 URL = "jdbc:mysql://localhost:3306/hrm_user?useUnicode=true&characterEncoding=utf8";
			 USER= "root";
			 PASSWORD = "";
			 conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	};
	public static Connection sqlConnection() {
		 Connection conn = null;
	        try {
	        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	 String dbURL = "jdbc:sqlserver://localhost;databaseName=HRM;user=sa;password=123456";
	 		     conn = DriverManager.getConnection(dbURL);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    
	}
	
	/*
	 * public static void main(String[] args) { System.out.println(new
	 * DBConnectionUtil().sqlConnection()); }
	 */
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	public static void close(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pst) {
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn,Statement st, ResultSet rs) {
		close(rs);
		close(st);
		close(conn);
	}
	
	public static void close(Connection conn,PreparedStatement pst) {
		close(pst);
		close(conn);
	}
	public static void close(Connection conn,PreparedStatement pst, ResultSet rs) {
		close(rs);
		close(pst);
		close(conn);
	}
	public static void main(String[] args) {
		
		int result=0;
		final String sql="INSERT INTO guest(username,password) VALUES('nghia','123')";
		Connection conn = DBConnectionUtil.sqlConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
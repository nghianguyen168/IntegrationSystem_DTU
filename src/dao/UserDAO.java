package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import model.User;
import utils.DBConnectionUtil;

public class UserDAO {
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	Connection conn;
	public User checkLogin(String username, String password) {
		User user = null;
		final String sql = "SELECT * FROM user WHERE username=? AND password = ?";
		conn= DBConnectionUtil.hrmUserConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("gmail"), rs.getString("fullname"), new Role(rs.getInt("role_id"), ""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return user;
	}
	
	public User checkTrung(String username) {
		User user = null;
		final String sql = "SELECT * FROM user WHERE username=?";
		conn= DBConnectionUtil.hrmUserConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("gmail"), rs.getString("fullname"), new Role(rs.getInt("role_id"), ""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return user;
	}
	
	public List<User> findAll(){
		List<User> userList = new ArrayList<User>();
		final String sql ="SELECT u.*,r.* FROM user AS u INNER JOIN role AS r ON u.role_id = r.role_id ";
		conn=DBConnectionUtil.hrmUserConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("gmail"), rs.getString("fullname"), new Role(rs.getInt("role_id"), rs.getString("role_name")));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		return userList;
	}

	public int addItem(User user) {
		int result = 0;
		final String sql="INSERT INTO user(username,password,fullname,gmail,role_id) VALUES(?,?,?,?,?)";
		conn = DBConnectionUtil.hrmUserConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getRole().getRole_id());
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return result;
	}

	public int resetPassword(String username, String email, String password) {
		int result =0;
		final String sql= "UPDATE user SET password=? WHERE username=? AND gmail=?";
		conn= DBConnectionUtil.hrmUserConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, username);
			pst.setString(3, email);
			result= pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(conn, pst, rs);
		}
		
		return result;
	}
	
}

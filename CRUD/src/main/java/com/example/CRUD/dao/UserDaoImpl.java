package com.example.CRUD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.CRUD.dao.DBConnect;
import com.example.CRUD.model.User;

public class UserDaoImpl implements UserDao{
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	public int addUser(User user) {
		String sql="INSERT INTO user (username,password,email,phone,fullname) values(?,?,?,?,?)";
		int i=-1;
		try{
			conn=DBConnect.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getEmail());
			stmt.setString(4,user.getPhone());
			stmt.setString(5,user.getFullname());
			i=stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return i;
		
	}

	public int updateUser(User user,int userId) {
		int i=-1;
		String sql="update user set email=?,phone=?,fullname=? where id=?";
		try{
			conn=DBConnect.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,user.getEmail());
			stmt.setString(2,user.getPhone());
			stmt.setString(3,user.getFullname());
			stmt.setInt(4, userId);
			i=stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close(); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return i;
	}

	public int deleteUser(int userId) {
		int i=-1;
		String sql = "delete from user where id=?";
		try {
			conn=DBConnect.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			i=stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close(); 
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return i;
	}

	public User getUserById(int userId) {
		String sql="select id,username,email,phone,fullname from user where id=?";
		try {
			conn=DBConnect.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			rs=stmt.executeQuery();
			rs.next();
			return(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close(); 
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	}

	public List<User> getAllUsers() {
		String sql="select id,username,email,phone,fullname from user";
		List<User> list=new ArrayList<User>();
		try {
			conn=DBConnect.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close(); 
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return list;
	}

}

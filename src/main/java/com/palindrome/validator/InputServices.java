package com.palindrome.validator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class InputServices {
	private static String url = "jdbc:postgresql://localhost:4321/palindromeInput";
	private static String username = "postgres";
	private static String password = "tiger";
	private static String driverpath = "org.postgresql.Driver";
	private static Connection conn;
	
	static{
		try {
			Class.forName(driverpath);
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int save(InputClass i) {
		int result = 0;
		String sql = "INSERT into palindrometable values(?,?,?,?)";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);			
			pstm.setInt(1,i.getId());
			pstm.setString(2,i.getInput());
			pstm.setString(3,i.getYes());
			pstm.setString(4,i.getNo());
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(int id) {
		int result = 0;
		String sql = "DELETE from palindrometable where id=?";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<InputClass> displayAll(){
		List<InputClass> li = new ArrayList<>();
		
		String sql = "SELECT * from palindrometable";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String inp = rs.getString(2);
				String yes = rs.getString(3);
				String no = rs.getString(4);
				
				li.add(new InputClass(id,inp,yes,no));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
}

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
		String sql = "INSERT into inputtable values(?,?,?)";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,i.getInput());
			pstm.setString(2,i.getYes());
			pstm.setString(3,i.getNo());
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(String str) {
		int result = 0;
		String sql = "DELETE from inputtable where input=?";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,str);
			
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<InputClass> displayAll(){
		List<InputClass> li = new ArrayList<>();
		
		String sql = "SELECT * from inputtable";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String inp = rs.getString(1);
				String yes = rs.getString(2);
				String no = rs.getString(3);
				
				li.add(new InputClass(inp,yes,no));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
}

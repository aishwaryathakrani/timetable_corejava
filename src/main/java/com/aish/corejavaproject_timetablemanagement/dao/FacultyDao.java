package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aish.corejavaproject_timetablemanagement.entity.Faculty;


public class FacultyDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	public Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/corejavatimetable", "root", "Aishwarya@16");
		} catch (Exception e) {
			System.err.println(e);
		}
		return con;
	}

   public int insertFaculty(int fid, int currentLoad, String fname, String specialization) throws SQLException {
		int n = 0;
		
		con = getConnect();
		pst = con.prepareStatement("insert into faculty values(?,?,?,?)");
		pst.setInt(1, fid);
		pst.setInt(2,currentLoad);

		pst.setString(3, fname);
		pst.setString(4, specialization);

		n = pst.executeUpdate();
	return n;

   }
   
	public int updateFaculty(int fid, int currentLoad,String fname, String specialization) {
		int n = 0;
		try {
			con = getConnect();
			Statement st = con.createStatement();
			String sql = "update faculty set fname='"+fname+"' ,currentLoad='"+currentLoad+"',specialization='"+specialization+"' where fid="+fid;
			n = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}


public int deleteFaculty(int fid)
{
	int n = 0;
	
	try {
		con = getConnect();
		pst = con.prepareStatement("delete from account where fid = ?");
		pst.setInt(1, fid);
		n = pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return n;
}

public Faculty viewFaculty(int fid)
{
	try {
		con = getConnect();
		ResultSet rs = null;
		pst = con.prepareStatement("select * from faculty where fid=?");
		pst.setInt(1, fid);
		rs = pst.executeQuery();
		if(rs.next())
		{
			return new Faculty(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public ArrayList<Faculty> viewFaculties()
{
	ArrayList<Faculty> al = new ArrayList<Faculty>();
	try {
		con = getConnect();
		ResultSet rs = null;
		pst = con.prepareStatement("select * from faculty");
		rs = pst.executeQuery();
		while(rs.next())
		{
			al.add(new Faculty(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
		}
		return al;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
}

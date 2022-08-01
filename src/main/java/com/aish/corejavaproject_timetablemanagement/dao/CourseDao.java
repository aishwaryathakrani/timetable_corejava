package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aish.corejavaproject_timetablemanagement.entity.Course;

public class CourseDao {
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
	   public int insertCourse(int cid, String coursename, double coursefees) throws SQLException {
			int n = 0;
			
			con = getConnect();
			pst = con.prepareStatement("insert into course values(?,?,?)");
			pst.setInt(1, cid);
			pst.setString(2,coursename);
			pst.setDouble(3, coursefees);

			n = pst.executeUpdate();
		return n;

	   }
		public int updateCourse(int cid, String coursename, double coursefees) {
			int n = 0;
			try {
				con = getConnect();
				Statement st = con.createStatement();
				String sql = "update course set coursename='"+coursename+"' ,coursefees='"+coursefees+"'where cid="+cid;
				n = st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;
		}

		public int deleteCourse(int cid)
		{
			int n = 0;
			
			try {
				con = getConnect();
				pst = con.prepareStatement("delete from course where cid = ?");
				pst.setInt(1, cid);
				n = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;
		}

		public Course viewCourse(int cid)
		{
			try {
				con = getConnect();
				ResultSet rs = null;
				pst = con.prepareStatement("select * from course where cid=?");
				pst.setInt(1, cid);
				rs = pst.executeQuery();
				if(rs.next())
				{
					return new Course(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public ArrayList<Course> viewCourses()
		{
			ArrayList<Course> al = new ArrayList<Course>();
			try {
				con = getConnect();
				ResultSet rs = null;
				pst = con.prepareStatement("select * from course");
				rs = pst.executeQuery();
				while(rs.next())
				{
					al.add(new Course(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
				}
				return al;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	}




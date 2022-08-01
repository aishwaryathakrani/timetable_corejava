package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aish.corejavaproject_timetablemanagement.entity.Batch;


public class BatchDao {

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
	   public int insertBatch(int bid, int size, int cid ) throws SQLException {
			int n = 0;
			
			con = getConnect();
			pst = con.prepareStatement("insert into batch values(?,?,?)");
			pst.setInt(1, bid);
			pst.setInt(2,size);
			pst.setInt(3, cid);

			n = pst.executeUpdate();
		return n;

	   }
		public int updateBatch(int bid, int size, int cid) {
			int n = 0;
			try {
				con = getConnect();
				Statement st = con.createStatement();
				String sql = "update batch set size='"+size+"' ,cid='"+cid+"'where bid="+bid;
				n = st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;
		}

		public int deleteBatch(int bid)
		{
			int n = 0;
			
			try {
				con = getConnect();
				pst = con.prepareStatement("delete from batch where bid = ?");
				pst.setInt(1, bid);
				n = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return n;
		}

		public Batch viewBatch(int bid)
		{
			try {
				con = getConnect();
				ResultSet rs = null;
				pst = con.prepareStatement("select * from batch where bid=?");
				pst.setInt(1, bid);
				rs = pst.executeQuery();
				if(rs.next())
				{
					return new Batch(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public ArrayList<Batch> viewBatches()
		{
			ArrayList<Batch> al = new ArrayList<Batch>();
			try {
				con = getConnect();
				ResultSet rs = null;
				pst = con.prepareStatement("select * from Batch");
				rs = pst.executeQuery();
				while(rs.next())
				{
					al.add(new Batch(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
				}
				return al;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}





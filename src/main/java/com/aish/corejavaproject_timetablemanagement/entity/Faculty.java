package com.aish.corejavaproject_timetablemanagement.entity;

public class Faculty {
	private int fid;
	private String fname;
	private String specialization;
	private int currentLoad ;
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faculty(int fid, int currentLoad,String fname, String specialization) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.specialization = specialization;
		this.currentLoad = currentLoad;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getCurrentLoad() {
		return currentLoad;
	}
	public void setCurrentLoad(int currentLoad) {
		this.currentLoad = currentLoad;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", specialization=" + specialization + ", currentLoad="
				+ currentLoad + "]";
	}
	

}

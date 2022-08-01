package com.aish.corejavaproject_timetablemanagement.entity;

public class Course {

private int cid;
private String coursename;
private double coursefees;
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public Course(int cid, String coursename, double coursefees) {
	super();
	this.cid = cid;
	this.coursename = coursename;
	this.coursefees = coursefees;
}

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public double getCoursefees() {
	return coursefees;
}
public void setCoursefees(double coursefees) {
	this.coursefees = coursefees;
}
@Override
public String toString() {
	return "Course [cid=" + cid + ", coursename=" + coursename + ", coursefees=" + coursefees + "]";
}


}



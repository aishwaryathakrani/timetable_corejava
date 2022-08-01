package com.aish.corejavaproject_timetablemanagement.service;

import java.util.ArrayList;

import com.aish.corejavaproject_timetablemanagement.dao.CourseDao;
import com.aish.corejavaproject_timetablemanagement.entity.Course;
import java.util.Scanner;


public class CourseService {
	CourseDao cdao = new CourseDao();
	Scanner sc = new Scanner(System.in);

	public boolean addCourse(int count)
	{
		int n = 0;
		while(count > 0)
		{
			System.out.println("Enter the Course details:");
			System.out.println("Enter the Course ID:");
			int cid = sc.nextInt();
			System.out.println("Enter the Course Name:");
			String coursename = sc.next();
			System.out.println("Enter the Course Fees:");
			double coursefees = sc.nextDouble();

			try {
			if(cdao.insertCourse(cid, coursename, coursefees)==1)
				n++;
			}catch(Exception e)
			{
				System.out.println(e);
			}
			count--;
		}
		if(n>0)
			return true;
		else
			return false;
	}
	public boolean updateCourse(int cid, String coursename, double coursefees)
	{
		int n = cdao.updateCourse(cid, coursename,coursefees);
		if(n > 0)
			return true;
		else
			return false;
	}

	public boolean deleteCourse(int cid)
	{
		cdao.deleteCourse(cid);
		return true;
	}
	
	public Course viewCourse(int cid)
	{
		return cdao.viewCourse(cid);
	}
	
	public ArrayList<Course> viewCourses()
	{
		return cdao.viewCourses();
	}


}




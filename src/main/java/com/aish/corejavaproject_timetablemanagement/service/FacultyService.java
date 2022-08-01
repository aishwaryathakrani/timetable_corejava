package com.aish.corejavaproject_timetablemanagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.aish.corejavaproject_timetablemanagement.dao.FacultyDao;

import com.aish.corejavaproject_timetablemanagement.entity.Faculty;


public class FacultyService {

	FacultyDao fdao = new FacultyDao();
	Scanner sc = new Scanner(System.in);
	
	public boolean addFaculty(int count)
	{
		int n = 0;
		while(count > 0)
		{
			System.out.println("Enter the Faculty details:");
			System.out.println("Enter the Faculty ID:");
			int fid = sc.nextInt();
			System.out.println("Enter the Faculty Name:");
			String fname = sc.next();
			System.out.println("Enter the Faculty Specialization:");
			String specialization = sc.next();

			System.out.println("Enter the Initial Load: ");
			int  curr_load = sc.nextInt();
			try {
			if(fdao.insertFaculty(fid, curr_load, fname,specialization)==1)
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
	public boolean updateFaculty(int fid, int curr_Load,String fname, String specializatiion)
	{
		int n = fdao.updateFaculty(fid, curr_Load,fname,specializatiion);
		if(n > 0)
			return true;
		else
			return false;
	}

	public boolean deleteFaculty(int fid)
	{
		fdao.deleteFaculty(fid);
		return true;
	}
	
	public Faculty viewFaculty(int fid)
	{
		return fdao.viewFaculty(fid);
	}
	
	public ArrayList<Faculty> viewFaculties()
	{
		return fdao.viewFaculties();
	}


}

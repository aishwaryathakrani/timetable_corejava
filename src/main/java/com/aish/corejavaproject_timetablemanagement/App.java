package com.aish.corejavaproject_timetablemanagement;

import java.util.Scanner;


import com.aish.corejavaproject_timetablemanagement.entity.*;
import com.aish.corejavaproject_timetablemanagement.service.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BatchService bsv = new BatchService();
    	CourseService csv = new CourseService();
    	FacultyService fsv = new FacultyService();
    	
    	int bid;
    	int size;
    	int cid;
    	double coursefees;
    	String coursename;
    	int fid;
    	int curr_Load;
    	String fname;
    	String specialization;
    	
    	char ch='Y';
    	while( ch=='Y') {
    		System.out.println("*********TIME TABLE MANAGEMENT SYSTEM***********");
    		System.out.println("10) BATCH DETAILS \n 11) COURSE DETAILS \n 12) FACULTY DETAILS");
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter your choice: ");
    		int option = sc.nextInt();
    		switch(option) {
    		case 10 : System.out.println("1) ADD BATCH \n 2) VIEW BATCH \n 3) VIEW BATCHES \n 4) UPDATE BATCH \n 5)DELETE BATCH");
    		System.out.println("Enter your choice: ");
    		int choice1 = sc.nextInt();
    		switch(choice1) {
    		case 1 : 				
    			System.out.println("Enter the number of Batches:");
    			int count = sc.nextInt();
    			bsv.addBatch(count);
			break;

    		case 2:
				System.out.println("Enter the batch id :");
				bid = sc.nextInt();
				System.out.println(bsv.viewBatch(bid));
				break;

    		case 3:
				for(Batch b:bsv.viewBatches())
				{
					System.out.println(b);
				}
				break;

    		case 4: 				
    			System.out.println("Enter the Batch details:");
    			System.out.println("Enter Batch ID");
    			bid = sc.nextInt();
    			System.out.println("Enter Batch Size");
    			size = sc.nextInt();
    			System.out.println("Enter Course ID");
    			cid = sc.nextInt();
    			bsv.updateBatch(bid,size,cid);
			break;

    		case 5:
				System.out.println("Enter the batch id:");
				bid = sc.nextInt();
				bsv.deleteBatch(bid);
				break;

    		}
    		break;
    		case 11 : System.out.println("1) ADD COURSE \n 2) VIEW COURSE \n 3) VIEW COURSES \n 4) UPDATE COURSE \n 5)DELETE COURSE");
    		System.out.println("Enter your choice: ");
    		int choice2 = sc.nextInt();
    		switch(choice2) {
    		case 1 :
    			System.out.println("Enter the number of Courses:");
    			int count = sc.nextInt();
    			csv.addCourse(count);
    			break;
    		case 2:
				System.out.println("Enter the Course ID:");
				cid = sc.nextInt();
				System.out.println(csv.viewCourse(cid));
				break;

    		case 3:
				for(Course c:csv.viewCourses())
				{
					System.out.println(c);
				}
				break;

    		case 4:
    			System.out.println("Enter the Course details:");
    			cid = sc.nextInt();
    			coursename = sc.next();
    			coursefees = sc.nextDouble();
    			csv.updateCourse(cid,coursename,coursefees);
    			break;
    		case 5:
				System.out.println("Enter the Course id:");
				cid = sc.nextInt();
				csv.deleteCourse(cid);
				break;

    		}
    		break;
    		case 12 : System.out.println("1) ADD FACULTY \n 2) VIEW FACULTY \n 3) VIEW FACULTIES \n 4) UPDATE FACULTY \n 5)DELETE FACULTY");
    		System.out.println("Enter your choice: ");
    		int choice3 = sc.nextInt();
    		switch(choice3) {
    		case 1 :     			
    				System.out.println("Enter the number of Faculties:");
    				int count = sc.nextInt();
    				fsv.addFaculty(count);
    				break;

    		case 2:
					System.out.println("Enter the Faculty ID:");
					fid = sc.nextInt();
					System.out.println(fsv.viewFaculty(fid));
					break;

    		case 3: 				
    				for(Faculty f:fsv.viewFaculties())
    				{
    					System.out.println(f);
    				}
    				break;

    		case 4:
    				System.out.println("Enter the Faculty details:");
    				System.out.println("Enter the Faculty ID:");
    				fid = sc.nextInt();
    				System.out.println("Enter the Current Load:");
    				curr_Load = sc.nextInt();
    				System.out.println("Enter the Faculty Name:");
    				fname = sc.next();
    				System.out.println("Enter the Specialization:");
    				specialization = sc.next();
    				fsv.updateFaculty(fid,curr_Load,fname,specialization);
    				break;

    		case 5:
					System.out.println("Enter the Faculty id:");
					fid = sc.nextInt();
					fsv.deleteFaculty(fid);
					break;

    		}
    	}

    	}
    }
}

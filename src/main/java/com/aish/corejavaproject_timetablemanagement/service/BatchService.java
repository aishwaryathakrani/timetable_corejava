package com.aish.corejavaproject_timetablemanagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.aish.corejavaproject_timetablemanagement.dao.BatchDao;
import com.aish.corejavaproject_timetablemanagement.entity.Batch;


public class BatchService {
	
	BatchDao bdao = new BatchDao();
	Scanner sc = new Scanner(System.in);
	
	public boolean addBatch(int count)
	{
		int n = 0;
		while(count > 0)
		{
			System.out.println("Enter the Batch details:");
			System.out.println("Enter the Batch ID:");
			int bid = sc.nextInt();
			System.out.println("Enter the Size of Batch:");
			int size = sc.nextInt();
			System.out.println("Enter the Course ID:");
			int cid = sc.nextInt();

			try {
			if(bdao.insertBatch(bid, size, cid)==1)
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
	public boolean updateBatch(int bid, int size, int cid)
	{
		int n = bdao.updateBatch(bid, size,cid);
		if(n > 0)
			return true;
		else
			return false;
	}

	public boolean deleteBatch(int bid)
	{
		bdao.deleteBatch(bid);
		return true;
	}
	
	public Batch viewBatch(int bid)
	{
		return bdao.viewBatch(bid);
	}
	
	public ArrayList<Batch> viewBatches()
	{
		return bdao.viewBatches();
	}
    


}




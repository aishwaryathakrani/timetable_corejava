package com.aish.corejavaproject_timetablemanagement.entity;

public class Batch {

	private int bid;
	private int size;
	private int cid;

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int bid,  int size, int cid) {
		super();
		this.bid = bid;
		this.size = size;
		this.cid =cid;
		
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", size=" + size + ", cid=" + cid + "]";
	}


}



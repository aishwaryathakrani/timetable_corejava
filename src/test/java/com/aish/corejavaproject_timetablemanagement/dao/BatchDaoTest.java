package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;

import com.aish.corejavaproject_timetablemanagement.dao.BatchDao;


public class BatchDaoTest {
	BatchDao bdao = new BatchDao();
	@Test
	public void testGetConnect() {
		Assert.assertNotNull(bdao.getConnect());
	}
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testInsertBatch() throws SQLException {
		bdao.insertBatch(301,30,101);
	}

	@Test
	public void testUpdateBatch() {
		Assert.assertEquals(1,bdao.updateBatch(301,25,101));
	}


	@Test
	public void testDeleteBatch() {
		Assert.assertEquals(1, bdao.deleteBatch(105));
	}

	@Test
	public void testViewBatch() {
		Assert.assertNotNull(bdao.viewBatch(101));
	}

	@Test
	public void testViewBatches() {
		Assert.assertNotNull(bdao.viewBatches());
	}

}




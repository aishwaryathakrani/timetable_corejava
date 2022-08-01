package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;

public class FacultyDaoTest {
	FacultyDao fdao = new FacultyDao();
	@Test
	public void testGetConnect() {
		Assert.assertNotNull(fdao.getConnect());
	}
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testInsertFaculty() throws SQLException {
		fdao.insertFaculty(101,0,"Archana","Java");
	}

	@Test
	public void testUpdateFaculty() {
		Assert.assertEquals(1,fdao.updateFaculty(101,1,"Archana","Java"));
	}


	@Test
	public void testDeleteFaculty() {
		Assert.assertEquals(1, fdao.deleteFaculty(101));
	}

	@Test
	public void testViewFacuty() {
		Assert.assertNotNull(fdao.viewFaculty(101));
	}

	@Test
	public void testViewFaculties() {
		Assert.assertNotNull(fdao.viewFaculties());
	}

}




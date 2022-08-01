package com.aish.corejavaproject_timetablemanagement.dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;

public class CourseDaoTest {
	CourseDao cdao = new CourseDao();
	@Test
	public void testGetConnect() {
		Assert.assertNotNull(cdao.getConnect());
	}
	
	@Test(expected=SQLIntegrityConstraintViolationException.class)
	public void testInsertCourse() throws SQLException {
		cdao.insertCourse(101,"DotNet",5500.0);
	}

	@Test
	public void testUpdateCourse() {
		Assert.assertEquals(1,cdao.updateCourse(101,"MachineLearning",10000.0));
	}


	@Test
	public void testDeleteCourse() {
		Assert.assertEquals(1, cdao.deleteCourse(101));
	}

	@Test
	public void testViewCourse() {
		Assert.assertNotNull(cdao.viewCourse(101));
	}

	@Test
	public void testViewCourses() {
		Assert.assertNotNull(cdao.viewCourses());
	}

}




package in.co.rays.proj4.testmodel;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {
	
	static CourseModel model = new CourseModel();
	
	public static void main(String[] args) throws Exception {
		//testNextPk();
		//testAdd();
		//testUpdate();
		//testDelete();
		testFindByPk();
	}
	
	public static void testNextPk() throws SQLException {
		
		int i = model.nextPk();
		System.out.println(i);
		
	}
	
	public static void testAdd() throws Exception {
		CourseBean bean = new CourseBean();
		
		bean.setName("Java Development");
		bean.setDuration("6 Mounths");
		bean.setDescription("Core java, Advance Java, Projects");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
			model.add(bean);
			System.out.println("Course added successfully");
		

	}
	public static void testUpdate() throws Exception {
		CourseBean bean = new CourseBean();
		
		bean.setId(2);
		bean.setName("Java Development");
		bean.setDuration("6 Mounths");
		bean.setDescription("Core Java, DSA");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
			model.update(bean);
			System.out.println("Course updated successfully");
		
		
	}
	
	public static void testDelete() throws Exception {
		
		CourseBean bean = new CourseBean();
		bean.setId(3);
	
			model.delete(bean);
			System.out.println("Student Deleted Successfully");
	}
	
	public static void testFindByPk() throws Exception {
		CourseBean bean = new CourseBean();
		
		bean  = model.findByPk(1);
	
	
		System.out.print("Id : " + bean.getId());
		System.out.print("Name : " + bean.getName());
		System.out.print("Duration : " + bean.getDuration());
		System.out.println("Discraption : " + bean.getDescription());
	}
	
	
	
	
	
	

}

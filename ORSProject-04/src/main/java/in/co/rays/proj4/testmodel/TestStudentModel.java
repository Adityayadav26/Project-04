package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {
	static StudentModel model = new StudentModel();
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testNextPk();
		//testUpdate();
		//testDelete();
          testfindByPk();		
	}
	
	public static void testNextPk() throws Exception {
		int i = model.nextPk();
		System.out.println(i);
	}
	
	public static void testAdd() throws Exception {
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setFirstName("aditya");
		bean.setLastName("yadav");
		bean.setDob(sdf.parse("2005-10-26"));
		bean.setGender("male");
		bean.setMobileNo("9863543739");
		bean.setEmail("aditya@gamil.com");
		bean.setCollegeId(1);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
		System.out.println("Student Added Successfully");
		
	}
	
	public static void testUpdate() throws Exception {
		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			bean.setId(2);
			bean.setFirstName("aditya");
			bean.setLastName("yadav");
			bean.setDob(sdf.parse("2005-10-26"));
			bean.setGender("male");
			bean.setMobileNo("7220044837");
			bean.setEmail("adii@gmail.com");
			bean.setCollegeId(4);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(bean);
			System.out.println("Student Updated Successfully");
	
	}
	
	public static void testDelete() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setId(3);
		
			model.delete(bean);
			System.out.println("Student Deleted Successfully");
		
	}
	
	public static void testfindByPk() throws Exception {
		
		StudentBean bean = model.findByPk(1);
		System.out.println("Id : " + bean.getId());
		System.out.println("DOB : " + bean.getDob());
		System.out.println("Mobile no. : " + bean.getMobileNo());
		System.out.println("Email : " + bean.getEmail());
		System.out.println("College ID : " + bean.getCollegeId());
	}
	
	public static void testSearch() {
		
	}

}

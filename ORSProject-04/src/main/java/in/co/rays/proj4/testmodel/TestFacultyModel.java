package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {
	static FacultyModel model = new FacultyModel();
	
	public static void main(String[] args) throws Exception {
		//testAdd();
	//	testNextPk();
	//	testUpdate();
		//testDelete();
		//testFindByPk();
		testSearch();
	}
	
	public static void testNextPk() throws Exception {
		
		int i = model.nextPk();
		System.out.println(i);
	}
	
	public static void testAdd() throws Exception {
		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setFirstName("uday");
		bean.setLastName("dabi");
		bean.setDob(sdf.parse("2004-06-06"));
		bean.setGender("male");
		bean.setMobileNo("0123456789");
		bean.setEmail("uday@gmail.com");
		bean.setCollegeId(1);
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
		System.out.println("Faculty added successfully");
	
	}
	
	public static void testUpdate() throws Exception {
		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			bean.setId(2);
			bean.setFirstName("uday");
			bean.setLastName("Rani");
			bean.setDob(sdf.parse("2002-02-16"));
			bean.setGender("male");
			bean.setMobileNo("3216549870");
			bean.setEmail("rr@gmail.com");
			bean.setCollegeId(2);
			bean.setCourseId(1);
			bean.setSubjectId(1);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(bean);
			System.out.println("Faculty added successfully");
		
		
	}
	
	public static void testDelete() throws Exception {
		FacultyBean bean = new FacultyBean();
		bean.setId(3);
		
		model.delete(bean);
		System.out.println("Student Deleted Successfully");
		
	}

	public static void testFindByPk() throws Exception {
		FacultyBean bean = new FacultyBean();
		
			bean = model.findByPk(1);
			
			
			System.out.print("Name : " + bean.getFirstName() );
			System.out.print("Course : " + bean.getCourseName());
			System.out.print("Subject : " + bean.getSubjectName());
			System.out.print("College : " + bean.getCollegeName());
			System.out.println("Email : " + bean.getEmail());

		}
	public static void testSearch() {
		
	}
	


	

}

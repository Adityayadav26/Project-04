package in.co.rays.proj4.testmodel;



import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	   static SubjectModel model = new SubjectModel();
	
	public static void main(String[] args) throws Exception {
		//testnextpk();
		//testAdd();
		//testUpdate();
		//testDelete();
		testFindByPk();
	}

	public static void testnextpk() throws Exception {
		int i = model.nextPk();
		System.out.println(i);
		
	}
	
	public static void testAdd() throws Exception {
		SubjectBean bean = new SubjectBean();
		
		bean.setName("English");
		bean.setCourseId(1);
		bean.setDescription("sentence,advance");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
			model.add(bean);
			System.out.println("Subject added successfully");
	
	}
	
	public static void testUpdate() throws Exception {
		SubjectBean bean = new SubjectBean();
		
		bean.setId(2);
		bean.setName("CSS");
		bean.setCourseId(1);
		bean.setDescription("CSS, Telwint CSS");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
			model.update(bean);
			System.out.println("Subject updated successfully");
		
	}
	
	public static void testDelete() throws Exception {
		SubjectBean bean = new SubjectBean();
		
		bean.setId(2);
		
		model.delete(bean);
		System.out.println("Subject Deletetd Successfully");
		
	}
	
	public static void testFindByPk() throws Exception {
		SubjectBean bean = new SubjectBean();
		
		bean = model.findByPk(1);
		System.out.print("Id : " + bean.getId());
		System.out.print("Name : " + bean.getName());
		System.out.print("Course Name : " + bean.getCourseName());
		System.out.println("Discraption : " + bean.getDescription());
	}
		
	
	
	
		
	
	
}

package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {
	static MarksheetModel model = new MarksheetModel();
	
	public static void main(String[] args) throws Exception {
		//testNextPk();
		//testAdd();
		//testUpdate();
		//testDelete();
		testFindByPk();
	}
	
	public static void testNextPk() throws Exception {
		int i = model.nextPk();
		System.out.println(i);
		
	}
	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo("20030310683673");
		bean.setStudentId(1);
		bean.setPhysics(90);
		bean.setChemistry(79);
		bean.setMaths(90);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
			model.add(bean);
			System.out.println("Marksheet added successfully");
	
	}
	
	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(2);
		bean.setRollNo("200303105211");
		bean.setStudentId(3);
		bean.setPhysics(80);
		bean.setChemistry(89);
		bean.setMaths(70);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
			model.update(bean);
			System.out.println("Marksheet updated successfully");
	}

	public static void testDelete() throws Exception {
		MarksheetBean bean  = new MarksheetBean();
		bean.setId(2);

			model.delete(bean);
			System.out.println("Marksheet deleted successfully");
		
		
	}
	public static void testFindByPk() throws Exception {
        MarksheetBean bean = new MarksheetBean();
        
			bean = model.findByPk(1);
			System.out.print("Id : " + bean.getId());
			System.out.print("Roll No. : " + bean.getRollNo());
			System.out.print("Name : " + bean.getName());
			System.out.print("Maths : " + bean.getMaths());
			System.out.print("Physics : " +bean.getPhysics());
			System.out.println("Chemistry : " + bean.getChemistry());
	
	}
}

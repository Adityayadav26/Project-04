package in.co.rays.proj4.testmodel;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {
	public static RoleModel model = new RoleModel();

	public static void main(String[] args) throws Exception {

		 //testNextPk();
//		testadd();
		//testupdate();
		//testdelete();
		//testfindbypk();
		//testfindByName();
		testsearch();
		
     }

	private static void testadd() throws ApplicationException, DuplicateRecordException {

		try {
			RoleBean bean = new RoleBean();
			bean.setName("FACULTY");
			bean.setDescription("Faculty");
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(bean);
			 System.out.println("Data Successfull Add");
		} catch (ApplicationException | DuplicateRecordException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testNextPk() throws DatabaseException {

		RoleModel r = new RoleModel();
		int i = r.nextPk();
		System.out.println(i);
	}
	
	private static void testupdate() throws ApplicationException, SQLException {
		
			RoleBean bean = new RoleBean();
			bean.setId(3);
			bean.setName("admin");
			bean.setDescription("admin");
			bean.setCreatedBy("collegeee");
			bean.setModifiedBy("collegeeee");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(bean);
			
			}
	
	private static void testdelete() throws SQLException {
		
		RoleBean bean = new RoleBean();
		bean.setId(4);
		model.delete(bean);
	}
	
	private static void testfindbypk() throws Exception{
		
		RoleBean bean = model.findByPk(2L);
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		
		}
	
	private static void testfindByName() throws Exception {
		RoleBean bean = model.findByName("admin");
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
	}
	
	private static void testsearch() throws Exception {
		RoleBean bean = new RoleBean();
		List list = new ArrayList();
		bean.setName("student");
		list = model.Search(bean);
		
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (RoleBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
		
	}
			
	}
	}	
			
			
	
	
			
		
	



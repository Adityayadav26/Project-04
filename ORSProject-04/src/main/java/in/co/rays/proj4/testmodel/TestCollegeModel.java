package in.co.rays.proj4.testmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.util.JDBCDataSource;

public class TestCollegeModel {
	
	public static void main(String[] args) throws Exception {
		//testNextPk();
		testAdd();
		//testUpdate();
		//testDelete();
	}
	public static void testNextPk() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		
		int i = model.nextPk();
		System.out.println(i);
		
	}
	
	public static void testAdd() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		
		bean.setName("IIT Bombey");
		bean.setAddress("GoreGav");
		bean.setState("MH");
		bean.setCity("Mumbai");
		bean.setPhoneNo("9876543234");
		bean.setCreatedBy("IIT@gamil.com");
		bean.setModifiedBy("IIT@gamil.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		model.add(bean);
		System.out.println("DATA ADDED SUCCESSFULLY");
		
		
	}
	public static void testUpdate() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		
		bean.setId(2);
		bean.setName("IPS");
		bean.setAddress("INDORE");
		bean.setState("MP");
		bean.setCity("GWALIOR");
		bean.setPhoneNo("9876789876");
		bean.setCreatedBy("ips@gamil.com");
		bean.setModifiedBy("ips@gamil.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		model.update(bean);
		System.out.println("DATA UPDATED SUCCESSFULLY");
		
		
	}
	
	public static void testDelete() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		
		bean.setId(1);
		
		
		model.delete(bean);
		System.out.println("DATA DELETED SUCCESSFULLY");
		
		
	}
	
	}



		
	



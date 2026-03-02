package in.co.rays.proj4.testmodel;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {
	public static UserModel model = new UserModel();

	public static void main(String[] args) throws Exception {
		// testNextPk();
		//testAdd();
		//testUpdate();
		testDelete();
	}

	public static void testAdd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		// bean.setId(1);
		bean.setfirstName("Uday");
		bean.setlastName("Dabi");
		bean.setlogin("uday@gmail.com");
		bean.setpassword("uday123");
		bean.setdo(sdf.parse("2005-10-30"));
		bean.setmobileNo("9589359987");
		bean.setroleId(1);
		bean.setgender("male");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
		System.out.println("Data added Successfully ");

	}

	public static void testNextPk() throws Exception {

		int i = model.nextPk();
		System.out.println(i);
	}
	
	public static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		
		bean.setId(2);
		bean.setfirstName("Uday");
		bean.setlastName("Dabi");
		bean.setlogin("uday12@gmail.com");
		bean.setpassword("1234");
		bean.setdo(sdf.parse("2001-07-14"));
		bean.setmobileNo("7220044837");
		bean.setroleId(1);
		bean.setgender("mail");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
		System.out.println("Data update successfully");

	}
	
	public static void testDelete() throws Exception {
			
		UserBean bean = new UserBean();
		bean.setId(1);

		model.delete(bean);
		System.out.println("delete added successfully");
		
		
		
	}

}

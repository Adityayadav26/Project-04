package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws DatabaseException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;
	}

	public long add(UserBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		int pk = 0;

		/*
		 * UserBean existbean = findByLogin(bean.getlogin());
		 * 
		 * if (existbean != null) { throw new
		 * DuplicateRecordException("Login Id already exists"); }
		 */

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getfirstName());
			pstmt.setString(3, bean.getlastName());
			pstmt.setString(4, bean.getlogin());
			pstmt.setString(5, bean.getpassword());
			pstmt.setDate(6, new java.sql.Date(bean.getdob().getTime()));
			pstmt.setString(7, bean.getmobileNo());
			pstmt.setLong(8, bean.getroleId());
			pstmt.setString(9, bean.getgender());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	public void update(UserBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set first_name=?, last_name=?, login =?, password =?, dob =?, mobile_no =?, role_id =?, gender =?,created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
		pstmt.setString(1, bean.getfirstName());
		pstmt.setString(2, bean.getlastName());
		pstmt.setString(3, bean.getlogin());
		pstmt.setString(4, bean.getpassword());
		pstmt.setDate(5, new java.sql.Date(bean.getdob().getTime()));
		pstmt.setString(6, bean.getmobileNo());
		pstmt.setLong(7, bean.getroleId());
		pstmt.setString(8, bean.getgender());
		pstmt.setString(9, bean.getCreatedBy());
		pstmt.setString(10, bean.getModifiedBy());
		pstmt.setTimestamp(11, bean.getCreatedDatetime());
		pstmt.setTimestamp(12, bean.getModifiedDatetime());
		pstmt.setLong(13, bean.getId());
		pstmt.executeUpdate();
		conn.commit();
		JDBCDataSource.closeConnection(conn);

	}

	public void delete(UserBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		pstmt.setLong(1, bean.getId());
		pstmt.executeUpdate();
		conn.commit();
		JDBCDataSource.closeConnection(conn);
		System.out.println("user delete successfully");

	}
	
	public List<UserBean> search(UserBean bean) throws Exception{
		
		Connection conn = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		StringBuffer sql = new StringBuffer("Select from st_user where 1 = 1");
		
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	 pstmt.executeUpdate();
		
		 
		return list;
	}

	}

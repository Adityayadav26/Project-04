package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class CollegeModel {

	public Integer nextPk() throws Exception {

		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("Select max(id)from St_College");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return pk + 1;

	}

	public long add(CollegeBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		pk = nextPk();
		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("insert into st_college values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getAddress());
		pstmt.setString(4, bean.getState());
		pstmt.setString(5, bean.getCity());
		pstmt.setString(6, bean.getPhoneNo());
		pstmt.setString(7, bean.getCreatedBy());
		pstmt.setString(8, bean.getModifiedBy());
		pstmt.setTimestamp(9, bean.getCreatedDatetime());
		pstmt.setTimestamp(10, bean.getModifiedDatetime());
		pstmt.executeUpdate();
		conn.commit();
		JDBCDataSource.closeConnection(conn);
		return pk;

	}

	public void update(CollegeBean bean) throws Exception {
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_college set name =?, address =?, state =?, city =?, phone_no =?,created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getAddress());
		pstmt.setString(3, bean.getState());
		pstmt.setString(4, bean.getCity());
		pstmt.setString(5, bean.getPhoneNo());
		pstmt.setString(6, bean.getCreatedBy());
		pstmt.setString(7, bean.getModifiedBy());
		pstmt.setTimestamp(8, bean.getCreatedDatetime());
		pstmt.setTimestamp(9, bean.getModifiedDatetime());
		pstmt.setLong(10, bean.getId());

		pstmt.executeUpdate();
		conn.commit();
		JDBCDataSource.closeConnection(conn);
	}

	public void delete(CollegeBean bean) throws Exception {
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("delete from st_college where id =?");
		pstmt.setLong(1, bean.getId());
		pstmt.executeUpdate();

		conn.close();
		JDBCDataSource.closeConnection(conn);
	}

	public static CollegeBean findByPk(long pk) throws Exception {

		CollegeBean bean = null;
		Connection conn = null;

		StringBuffer sql = new StringBuffer("select * from st_college where id = ?");

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, pk);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new CollegeBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));
		}

		rs.close();
		JDBCDataSource.closeConnection(conn);

		return bean;
	}

	public List<CollegeBean> search(CollegeBean bean) throws Exception {

		StringBuffer sql = new StringBuffer("select * from st_college where 1 = 1");

		ArrayList<CollegeBean> list = new ArrayList<CollegeBean>();
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new CollegeBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneNo(rs.getString(6));
			bean.setCreatedBy(rs.getString(7));
			bean.setModifiedBy(rs.getString(8));
			bean.setCreatedDatetime(rs.getTimestamp(9));
			bean.setModifiedDatetime(rs.getTimestamp(10));
			list.add(bean);
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return list;

	}
}

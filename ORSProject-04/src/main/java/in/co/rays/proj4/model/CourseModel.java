package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.util.JDBCDataSource;

public class CourseModel {

	public Integer nextPk() throws SQLException {
		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_course");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return pk + 1;
	}

	public long add(CourseBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		pk = nextPk();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?, ?, ?, ?, ?, ?, ?, ?)");
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDuration());
		pstmt.setString(4, bean.getDescription());
		pstmt.setString(5, bean.getCreatedBy());
		pstmt.setString(6, bean.getModifiedBy());
		pstmt.setTimestamp(7, bean.getCreatedDatetime());
		pstmt.setTimestamp(8, bean.getModifiedDatetime());
		pstmt.executeUpdate();
		conn.commit();

		JDBCDataSource.closeConnection(conn);

		return pk;
	}

	public void update(CourseBean bean) throws Exception {
		Connection conn = null;

		conn = JDBCDataSource.getConnection();

		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_course set name = ?, duration = ?, description = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ? where id = ?");
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDuration());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedBy());
		pstmt.setString(5, bean.getModifiedBy());
		pstmt.setTimestamp(6, bean.getCreatedDatetime());
		pstmt.setTimestamp(7, bean.getModifiedDatetime());
		pstmt.setLong(8, bean.getId());
		pstmt.executeUpdate();
		conn.commit();
		pstmt.close();

		JDBCDataSource.closeConnection(conn);
	}

	public void delete(CourseBean bean) throws Exception {
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id = ?");
		pstmt.setLong(1, bean.getId());
		pstmt.executeUpdate();
		conn.commit();
		JDBCDataSource.closeConnection(conn);
	}

	public CourseBean findByPk(long pk) throws Exception {
		StringBuffer sql = new StringBuffer("select * from st_course where id = ?");
		CourseBean bean = null;
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, pk);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
		}
		rs.close();
		pstmt.close();
		JDBCDataSource.closeConnection(conn);
		return bean;
	}

	public List<CourseBean> search(CourseBean bean) throws Exception {
		StringBuffer sql = new StringBuffer("select * from st_course where 1=1");

		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setName(rs.getString(2));
			bean.setDuration(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCreatedBy(rs.getString(5));
			bean.setModifiedBy(rs.getString(6));
			bean.setCreatedDatetime(rs.getTimestamp(7));
			bean.setModifiedDatetime(rs.getTimestamp(8));
			list.add(bean);
		}
		rs.close();
		JDBCDataSource.closeConnection(conn);

		return list;
	}

}
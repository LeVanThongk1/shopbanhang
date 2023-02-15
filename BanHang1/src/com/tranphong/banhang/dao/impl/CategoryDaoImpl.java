package com.tranphong.banhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tranphong.banhang.dao.CategoryDao;
import com.tranphong.banhang.model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

	@Override
	public void add(Category category) {
		try {
			String sql = "insert into category(name) values(?)";
			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, category.getName());
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("loi them moi" + ex);
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from category where  id =?";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);

			st.executeUpdate();

		} catch (Exception ex) {
			System.out.println("loi xoa" + ex);
		}
		
	}

	@Override
	public void update(Category updateCategory) {
		try {
			String sql = "update category set name = ? where id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, updateCategory.getName());
			st.setInt(2, updateCategory.getId());

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("loi update moi" + ex);
		}
	}
	private Category rowMap(ResultSet rs) throws Exception {
		Category c = new Category();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));

		return c;
	}

	@Override
	public Category getIdD(int id) {
		try {
			String sql = "select * from category where id = ? ";
			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				return rowMap(rs);//gom ve 1 ham
			}
		} catch (Exception ex) {
			System.out.println("loi getId " + ex);
		}
		return null;
	}

	@Override
	public List<Category> search(String name) {
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select * from category where name like  ?";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, "%" + name + "%");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(rowMap(rs));//gom ve 1 ham
			}
		} catch (Exception ex) {
			System.out.println("loi search moi" + ex);
		}

		return list;
	}

	@Override
	public List<Category> search(String name, int offset, int maxPerPage) {
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select * from category where name like  ? LIMIT ? OFFSET ? ";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, "%"  + name + "%");
			st.setInt(2, maxPerPage);
			st.setInt(3, offset);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(rowMap(rs));//gom ve 1 ham
			}
		} catch (Exception ex) {
			System.out.println("loi search moi" + ex);
		}

		return list;
	}

	@Override
	public int count(String name) {
		try {
			String sql = "select count(*) as 'total' from category where name like  ?";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, "%" + name + "%");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				return rs.getInt("total");
			}
		} catch (Exception ex) {
			System.out.println("loi search moi" + ex);
		}

		return 0;
	}

}

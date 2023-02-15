package com.tranphong.banhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tranphong.banhang.dao.ProductDao;
import com.tranphong.banhang.model.Category;
import com.tranphong.banhang.model.Product;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {

	@Override
	public void add(Product product) {
		try {
			String sql = "insert into product(name,price,image,description,category_id) values(?,?,?,?,?);";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, product.getName());
			st.setInt(2, product.getPrice());
			st.setString(3, product.getImage());
			st.setString(4, product.getDescription());
			st.setInt(5, product.getCategory().getId());

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("loi them moi" + ex);
		}
		
	}

	@Override
	public void update(Product product) {
		
		try {
			String sql = "update product set name = ?, price = ?, image = ? , description = ?, category_id = ? WHERE id = ? ";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, product.getName());
			st.setInt(2, product.getPrice());
			st.setString(3, product.getImage());
			st.setString(4, product.getDescription());
			st.setInt(5, product.getCategory().getId());

			st.setInt(6, product.getId());
			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("loi update " + ex);
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from product where id = ?";

			Connection conn = super.getJDBCConnection();

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("loi delete" + ex);
		}
		
	}

	@Override
	public Product getId(int id) {
		try {
			String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
					+ "INNER JOIN category c ON p.category_id = c.id WHERE p.id = ?";

			Connection conn = super.getJDBCConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("c_name"));

				p.setCategory(category);

				return p;
			}
		} catch (Exception ex) {
			System.out.println("loi get " + ex);
		}
		return null;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> pList = new ArrayList<Product>();
		try {
			String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
					+ "INNER JOIN category c ON p.category_id = c.id WHERE p.name LIKE ?";
			Connection conn = super.getJDBCConnection();

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" + name + "%");

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("c_name"));

				p.setCategory(category);

				pList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("loi search" + ex);
		}
		return pList;
	}

	@Override
	public List<Product> search(int categoryId) {
		List<Product> pList = new ArrayList<Product>();
		try {
			String sql = "SELECT p.*, c.name as 'c_name' FROM product p "
					+ "INNER JOIN category c ON p.category_id = c.id WHERE p.category_id = ?";
			Connection conn = super.getJDBCConnection();

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, categoryId);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));

				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("c_name"));

				p.setCategory(category);

				pList.add(p);
			}
		} catch (Exception ex) {
			System.out.println("loi search" + ex);
		}
		return pList;
	}

}

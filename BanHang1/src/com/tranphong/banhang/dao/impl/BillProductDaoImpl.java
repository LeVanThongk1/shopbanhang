package com.tranphong.banhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.tranphong.banhang.dao.BillDaoProduct;

import com.tranphong.banhang.model.BillProduct;
import com.tranphong.banhang.model.Product;

public class BillProductDaoImpl extends JDBCConnection implements BillDaoProduct {

	@Override
	public void create(BillProduct p) {
		Connection conn = super.getJDBCConnection();

		try {

			String sql = "INSERT INTO bill_product(unit_price, quantity,bill_id,product_id) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setLong(1, p.getUnitPrice());
			st.setInt(2, p.getQuantity());
			st.setLong(3, p.getBill().getId());
			st.setLong(4, p.getProduct().getId());

			st.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(BillProduct p) {
		try {
			String sql = "update bill_product SET unit_price = ? , quantity = ?, bill_id = ?,product_id = ? WHERE id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, p.getUnitPrice());
			ps.setInt(2, p.getQuantity());
			ps.setInt(3, p.getBill().getId());
			ps.setInt(4, p.getProduct().getId());

			ps.setInt(5, p.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill_product WHERE id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}
	}

	@Override
	public BillProduct get(int id) {
		try {
			// lay tat cot cua billproduct va vai cot cua product
			String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id' from bill_product bp inner join product on bp.product_id = product.id WHERE bp.id=?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unit_price"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				return billProduct;
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return null;
	}

	@Override
	public List<BillProduct> search(int billId) {
		List<BillProduct> billList = new ArrayList<BillProduct>();

		try {
			String sql = "SELECT bp.*, product.name, product.image, product.id as 'p_id' from bill_product bp inner join product on bp.product_id = product.id WHERE bp.bill_id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, billId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillProduct billProduct = new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setUnitPrice(rs.getLong("unit_price"));
				billProduct.setQuantity(rs.getInt("quantity"));

				Product product = new Product();
				product.setName(rs.getString("product.name"));
				product.setId(rs.getInt("p_id"));
				product.setImage(rs.getString("image"));

				billProduct.setProduct(product);

				billList.add(billProduct);
			}
		} catch (Exception ex) {
			System.out.println("get loi :" + ex);
		}

		return billList;
	}

	

}

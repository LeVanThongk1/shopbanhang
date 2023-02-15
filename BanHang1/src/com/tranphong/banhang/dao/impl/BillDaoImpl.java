package com.tranphong.banhang.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tranphong.banhang.dao.BillDao;
import com.tranphong.banhang.model.Bill;
import com.tranphong.banhang.model.User;

public class BillDaoImpl extends JDBCConnection implements BillDao {

	@Override
	public void create(Bill b) {
		Connection conn = super.getJDBCConnection();
		try {
			String sql = "INSERT INTO bill(buyer_id, buy_date, price_total) values(?,?,?)";
			
			///THEM HANG SO RETURN GENERATED KEYS DE TRA VE ID TU GEN O SQL
			PreparedStatement st = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, b.getBuyer().getId());
			st.setString(2, b.getBuyDate());
			st.setLong(3, b.getPriceTotal());

			st.executeUpdate();

			/// tra ve ID gen ra, de luu sang billproduct
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {//NEU CO tao moi va ID tu gen o sql
				b.setId(rs.getInt(1));// lay id cua bill
			}
		} catch (Exception ex) {
			System.out.println("Loi :" + ex);
		}
	}

	@Override
	public void update(Bill b) {
		try {
			String sql = "update bill SET buyer_id = ? , buy_date = ?, price_total = ? WHERE id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, b.getBuyer().getId());
			ps.setString(2, b.getBuyDate());
			ps.setLong(3, b.getPriceTotal());
			ps.setInt(4, b.getId());
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}
	}

	@Override
	public void delete(int id) {
		try {
			String sql = "delete from bill WHERE id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

	}

	@Override
	public Bill get(int id) {
		try {
			String sql = "SELECT bill.id , bill.buy_date,bill.price_total, user.name  FROM bill inner join user ON bill.buyer_id = user.id WHERE bill.id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buy_date");
				Long pricetotal = rs.getLong("price_total");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				return bill;
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return null;
	}

	@Override
	public List<Bill> search(int userId) {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.id , bill.buy_date,bill.price_total, user.name  FROM bill inner join user ON bill.buyer_id = user.id WHERE user.id = ?";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buy_date");
				Long pricetotal = rs.getLong("price_total");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);

				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}

	@Override
	public List<Bill> getAll() {
		List<Bill> billList = new ArrayList<Bill>();
		try {
			String sql = "SELECT bill.id , bill.buy_date,bill.price_total, user.name  FROM bill inner join user ON bill.buyer_id = user.id";
			Connection conn = super.getJDBCConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("id");
				String buyerName = rs.getString("name");
				String buydate = rs.getString("buy_date");
				Long pricetotal = rs.getLong("price_total");

				Bill bill = new Bill();
				bill.setId(pid);
				bill.setBuyDate(buydate);
				bill.setPriceTotal(pricetotal);

				User buyer = new User();
				buyer.setName(buyerName);
				bill.setBuyer(buyer);
				billList.add(bill);
			}
		} catch (Exception ex) {
			System.out.println("Update loi :" + ex);
		}

		return billList;
	}
	
}

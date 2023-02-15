package com.tranphong.banhang.dao;

import java.util.List;

import com.tranphong.banhang.model.BillProduct;

public interface BillDaoProduct {
	void create (BillProduct b);
	void update(BillProduct b);
	void delete(int id);
	BillProduct get(int id);
	List<BillProduct> search(int billId);
}

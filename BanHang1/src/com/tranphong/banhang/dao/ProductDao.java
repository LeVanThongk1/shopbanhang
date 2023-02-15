package com.tranphong.banhang.dao;

import java.util.List;

import com.tranphong.banhang.model.Product;

public interface ProductDao {
	void add(Product product);
	void update(Product product);
	void delete(int id);
	Product getId(int id);
	List<Product> search(String name);
	List<Product> search(int category);
}

package com.tranphong.banhang.dao;

import java.util.List;

import com.tranphong.banhang.model.Category;

public interface CategoryDao {
	void add(Category category);
	void delete(int id);
	void update(Category updateCategory);
	Category getIdD(int id);
	List<Category> search(String name);
	List<Category> search(String name,int offset,int maxPerPage);
	int count(String name);
}

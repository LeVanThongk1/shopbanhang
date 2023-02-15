package com.tranphong.banhang.dao;

import java.util.List;

import com.tranphong.banhang.model.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int id);
	void updateLoginCounter(int id,int counter);
	User get(int id); //duy nhat
	User getByUsername(String username); //duy nhat
	List<User> search(String name);
}

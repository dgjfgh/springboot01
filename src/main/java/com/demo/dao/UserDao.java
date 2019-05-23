package com.demo.dao;

import com.demo.bean.User;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	int update(User user);

	void delete(Long id);

}
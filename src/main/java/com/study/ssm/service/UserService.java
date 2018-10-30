package com.study.ssm.service;

import java.util.List;

import com.study.ssm.model.User;

public interface UserService {

	public User getUserById(int userId);
	
	public int insertUser(User user);
	
	public List<User> getUserList();

	public int deleteUser(Integer id);
	
	public int updateUser(User user);
}

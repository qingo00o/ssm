package com.study.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.ssm.dao.UserMapper;
import com.study.ssm.model.User;
import com.study.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	@Override
	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public int insertUser(User user) {
		return	userMapper.insert(user);
	}
	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}
	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}

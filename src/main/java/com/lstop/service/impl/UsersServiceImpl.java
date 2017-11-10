package com.lstop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lstop.dao.UserMapper;
import com.lstop.pojo.User;
import com.lstop.service.UsersService;
@Service
@Scope("prototype")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UserMapper dao;

	@Override
	public User selectByPrimaryKey(Integer uid) {
		return dao.selectByPrimaryKey(uid);
	}

	@Override
	public List<User> selectByUnameAndUpassword(User user) {
		return dao.selectByUnameAndUpassword(user);
	}

	@Override
	public int insert(User user) {
		return dao.insert(user);
	}

	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer uid) {
		return dao.deleteByPrimaryKey(uid);
	}

	@Override
	public List<User> selectByPage(int page, int perpage) {
		return dao.selectByPage(page, perpage);
	}
	
	
}

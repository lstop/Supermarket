package com.lstop.service;

import java.util.List;

import com.lstop.pojo.User;

public interface UsersService {
	User selectByPrimaryKey(Integer uid);
	
	List<User> selectByUnameAndUpassword(User user);
	
	int insert(User user);
	
	List<User> selectAll();
	
	int updateByPrimaryKey(User record);
	
	int deleteByPrimaryKey(Integer uid);
	
	List<User> selectByPage(int page,int perpage);
	
	
}

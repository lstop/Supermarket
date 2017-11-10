package com.lstop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lstop.pojo.User;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByUnameAndUpassword(User user);
    
    List<User> selectAll();
    
    List<User> selectByPage(int page,int perpage);
}
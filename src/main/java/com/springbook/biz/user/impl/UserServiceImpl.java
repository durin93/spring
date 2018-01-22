package com.springbook.biz.user.impl;

import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public UserVO getUser(UserVO vo){
		return userDAO.getUser(vo);
	}
	
}

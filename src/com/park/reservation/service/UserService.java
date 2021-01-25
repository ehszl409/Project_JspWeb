package com.park.reservation.service;

import com.park.reservation.domain.user.User;
import com.park.reservation.domain.user.UserDao;
import com.park.reservation.domain.user.dto.JoinReqDto;
import com.park.reservation.domain.user.dto.LoginReqDto;

public class UserService {
	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();	
	}
	
	public int 회원가입(JoinReqDto dto) {
		return userDao.join(dto);
	}
	
	public int 유저네임중복체크(String username) {
		return userDao.findByUsername(username);
	}
	
	public User 로그인 (LoginReqDto dto) {
		return userDao.findByUsernameAndPassword(dto);
	}
}

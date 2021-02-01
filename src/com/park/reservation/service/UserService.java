package com.park.reservation.service;

import java.util.List;

import com.park.reservation.domain.user.User;
import com.park.reservation.domain.user.UserDao;
import com.park.reservation.domain.user.dto.JoinReqDto;
import com.park.reservation.domain.user.dto.LoginReqDto;
import com.park.reservation.domain.user.dto.MyPageReqDto;

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
	
	public List<MyPageReqDto> 마이페이지(int id) {
		return userDao.findByUserId(id);
	}
	
	public User 유저정보(int id) {
		return userDao.findById(id);
	}
}

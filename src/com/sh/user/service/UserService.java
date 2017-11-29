package com.sh.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.entity.User;
import com.sh.user.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Resource
	private UserDao userDao;
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<User> listAllUser(){
		return userDao.findAll();
	}
	/**
	 * 添加用户
	 * @return
	 */
	public void addUser(User u){
		userDao.addUser(u);
	}
	/**
	 * 根据email来查询用户
	 * @return
	 */
	public User listByEmail(String email){
		return userDao.findByEmail(email);
	}
}

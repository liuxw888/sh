package com.sh.user.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.entity.LoginUser;

@Repository
public class LoginUserDaoImpl{

	@Resource
	private SessionFactory sessionFactory;
	
	public LoginUser findById(String loginName){
//		return super.get(loginName);
		LoginUser lu=this.sessionFactory.getCurrentSession().get(LoginUser.class, loginName);
		return lu;
	}
}

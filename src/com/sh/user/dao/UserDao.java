package com.sh.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;
import com.sh.entity.User;
import com.sh.framework.BaseDao;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<User> findAll(){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from User");
			List<User> list = query.list();
			for(User u:list){
				System.out.println(u);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 添加用户
	 * @return
	 */
	public void addUser(User u){
		try {
			this.sessionFactory.getCurrentSession().save(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据email来查询用户
	 * @return
	 */
	public User findByEmail(String email){
		try {
			String sql = "from User where email=?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, email);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

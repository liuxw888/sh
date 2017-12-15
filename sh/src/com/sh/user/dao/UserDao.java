package com.sh.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.User;

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
	public Integer addUser(User u){
		try {
			this.sessionFactory.getCurrentSession().save(u);
			return u.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	public void deleteByEmail(Integer id) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete User where email=?";
			Transaction t = this.sessionFactory.openSession().beginTransaction();
			Query query=this.sessionFactory.openSession().createQuery(sql);
			query.setParameter(0, id);
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

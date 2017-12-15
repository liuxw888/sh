package com.sh.product.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.entity.ProductType;
@Repository
public class ProductTypeDao {
	@Resource
	private SessionFactory sessionFactory;
	public List<ProductType> findAll(){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from "+ProductType.class.getSimpleName());
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

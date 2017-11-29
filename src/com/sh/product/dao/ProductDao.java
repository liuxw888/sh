package com.sh.product.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;

@Repository
public class ProductDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询全部产品
	 * @return
	 */
	public List<Product> findAll(){
		try{
			System.out.println("dao..........");
			Query query=this.sessionFactory.getCurrentSession().createQuery("from Product");
			List<Product> list = query.list();
			for(Product p:list){
				System.out.println(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据id来查询产品
	 * @return
	 */
	public Product findById(Integer id){
		try{
			Product p = this.sessionFactory.getCurrentSession().get(Product.class,id);
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 统计数据个数
	 * @return
	 */
	public int findCountByPage(){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("select count("+"*"+") from "+Product.class.getSimpleName());

			return new Long((long)query.uniqueResult()).intValue();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 增加产品
	 * @return
	 */
	public void addProduct(Product p){
		try{
			this.sessionFactory.getCurrentSession().save(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 删除产品
	 * @return
	 */
	public void delete(Object entity) throws Exception {
		this.sessionFactory.getCurrentSession().delete(entity);
	}
	public void deleteProduct(Integer id){
		try{
			Session s=this.sessionFactory.openSession();
			Transaction t=s.beginTransaction();
			s.delete(s.get(Product.class, id));
//			Transaction t = this.sessionFactory.getCurrentSession().beginTransaction();
//			Product p=this.sessionFactory.getCurrentSession().get(Product.class, id);
//			this.sessionFactory.getCurrentSession().delete(p);
			t.commit();
//			this.sessionFactory.getCurrentSession().createQuery("delete Product p where p.id="+id).executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 修改产品
	 * @return
	 */
	public void editProduct(Product p) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(p);
		t.commit();
	}
	/**
	 * 分页查询数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPage(int pageNum, int pageSize){
		try{
			Query query=this.sessionFactory.getCurrentSession().createQuery("from "+Product.class.getSimpleName());
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

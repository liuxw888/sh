package com.sh.product.service;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sh.entity.Product;
import com.sh.product.dao.ProductDao;

@Service
@Transactional
public class ProductService {
	@Resource
	private ProductDao pd;
	
	public List<Product> listAll(){
		System.out.println("service.............");
		return pd.findAll();
	}
	public void addProduct(Product p){
		pd.addProduct(p);
	}
	
	@Transactional(readOnly=false)
	public void deleteById(Integer id){
		try {
			pd.deleteProduct(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int findCount() {
		// TODO Auto-generated method stub
		return pd.findCountByPage();
	}
	public List<Product> findByPage(int num, int i) {
		return pd.findByPage(num, i);
	}
	@Transactional(readOnly=false)
	public void updateProduct(Product p){
		pd.editProduct(p);
	}
	public Product findProductById(Integer id) {
		return pd.findById(id);
	}
}

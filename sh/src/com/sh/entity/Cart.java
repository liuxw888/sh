package com.sh.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Integer count = 1;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Map<Integer, CartItem> getContainer() {
		return container;
	}
	public void setContainer(Map<Integer, CartItem> container) {
		this.container = container;
	}
	public Map<Integer, CartItem> container=new HashMap<Integer, CartItem>();
	public void addCart(Product pro){
		if(container.containsKey(pro.getId())){
			CartItem ci=container.get(pro.getId());
			ci.setCount(ci.getCount()+count);
		}else{
			CartItem ci=new CartItem();
			ci.setProduct(pro);
			ci.setCount(count);
			container.put(pro.getId(), ci);
		}
	}
	public void deleteCart(Integer id){
		if(container.containsKey(id)){
			CartItem ci=container.remove(id);
		}
	}
}

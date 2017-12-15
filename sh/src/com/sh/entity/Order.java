package com.sh.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Order {
	private Integer count = 1;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Map<Integer, OrderItem> getContainer() {
		return container;
	}
	public void setContainer(Map<Integer, OrderItem> container) {
		this.container = container;
	}
	public Map<Integer, OrderItem> container=new HashMap<Integer, OrderItem>();
	public void addOrder(Product pro){
		if(container.containsKey(pro.getId())){
			OrderItem ci=container.get(pro.getId());
			ci.setCount(ci.getCount()+count);
		}else{
			OrderItem ci=new OrderItem();
			ci.setProduct(pro);
			ci.setCount(count);
			container.put(pro.getId(), ci);
		}
	}
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		if(container.containsKey(id)){
			OrderItem ci=container.remove(id);
		}
	}
}

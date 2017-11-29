package com.sh.entity;

import java.util.HashMap;
import java.util.Map;

public class Order {
	public Map<Integer, OrderItem> container=new HashMap<Integer, OrderItem>();
	public void addOrder(Product pro){
		if(container.containsKey(pro.getId())){
			OrderItem ci=container.get(pro.getId());
			ci.setCount(ci.getCount()+1);
		}else{
			OrderItem ci=new OrderItem();
			ci.setProduct(pro);
			ci.setCount(1);
			container.put(pro.getId(), ci);
		}
	}
}

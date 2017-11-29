package com.sh.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sh.entity.Order;
import com.sh.entity.OrderItem;
import com.sh.entity.Product;
import com.sh.product.dao.ProductTypeDao;
import com.sh.product.service.ProductService;

@Controller
@RequestMapping("/Order")
public class OrderController {
	@Resource
	private ProductService productService;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping("/toListOrder")
	public String toProductList(HttpServletRequest request, HttpServletResponse response){
		try {
			String id=request.getParameter("orderId");
			Product p=productService.findProductById(Integer.parseInt(id));
			HttpSession session=request.getSession();
			Order c=(Order)session.getAttribute("Order");
			if(c==null){
				c=new Order();
			}
			c.addOrder(p);
			session.setAttribute("Order", c);
			List<Product> list=productService.listAll();
			request.setAttribute("products", list);
			try {
				return "showCart";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/CountItem")
	public void CountItem(HttpServletRequest request, HttpServletResponse response){
		try {
			List<OrderItem> list = new ArrayList<OrderItem>();
			HttpSession session = request.getSession();
			Order c=(Order)session.getAttribute("Order");
			if(c!=null){
				Iterator i=c.container.values().iterator();
				int count=0;
				while(i.hasNext()){
					OrderItem ci=(OrderItem)i.next();
					count+=ci.getCount()*(ci.getProduct().getPrice());
					list.add(ci);
				}
				session.setAttribute("list", list);
				session.setAttribute("count",count);
			}
			request.getRequestDispatcher("/checkout.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@RequestMapping("/showOrder")
	public void showOrder(HttpServletRequest request, HttpServletResponse response){
		try {
			List<OrderItem> list = new ArrayList<OrderItem>();
			HttpSession session = request.getSession();
			Order c=(Order)session.getAttribute("Order");
			if(c!=null){
				Iterator i=c.container.values().iterator();
				int count=0;
				while(i.hasNext()){
					OrderItem ci=(OrderItem)i.next();
					count+=ci.getCount()*(ci.getProduct().getPrice());
					list.add(ci);
				}
				session.setAttribute("list", list);
				session.setAttribute("count",count);
			}
			request.getRequestDispatcher("/showOrder.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}



package com.sh.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.entity.Cart;
import com.sh.entity.CartItem;
import com.sh.entity.Product;
import com.sh.product.dao.ProductTypeDao;
import com.sh.product.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private ProductService productService;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping(value="/deleteCart")
	public void deleteCart(HttpServletRequest request, HttpServletResponse response){
		try {
			String id=request.getParameter("productid");
			if(null!=id){
				HttpSession session=request.getSession();
				Cart c=(Cart)session.getAttribute("cart");
				if(c==null){
					c=new Cart();
				}
				c.deleteCart(Integer.parseInt(id));
				session.setAttribute("cart", c);
			}
			request.getRequestDispatcher("showCart").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/toListProduct")
	public void toProductList(HttpServletRequest request, HttpServletResponse response){
		try {
			String id=request.getParameter("productid");
			String count = request.getParameter("count");
			if(null!=id){
				Product p=productService.findProductById(Integer.parseInt(id));
				HttpSession session=request.getSession();
				Cart c=(Cart)session.getAttribute("cart");
				if(c==null){
					c=new Cart();
				}
				if(null!=count){
					c.setCount(Integer.parseInt(count));
				}
				c.addCart(p);
				session.setAttribute("cart", c);
			}
			try {
				request.getRequestDispatcher("/product/listProduct").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/CountItem")
	public void CountItem(HttpServletRequest request, HttpServletResponse response){
		try {
			List<CartItem> list = new ArrayList<CartItem>();
			HttpSession session = request.getSession();
			Cart c=(Cart)session.getAttribute("cart");
			if(c!=null){
				Iterator i=c.container.values().iterator();
				int count=0;
				while(i.hasNext()){
					CartItem ci=(CartItem)i.next();
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
	@RequestMapping("/showCart")
	public void showCart(HttpServletRequest request, HttpServletResponse response){
		try {
			List<CartItem> list = new ArrayList<CartItem>();
			HttpSession session = request.getSession();
			Cart c=(Cart)session.getAttribute("cart");
			if(c!=null){
				Iterator i=c.container.values().iterator();
				int count=0;
				while(i.hasNext()){
					CartItem ci=(CartItem)i.next();
					count+=ci.getCount()*(ci.getProduct().getPrice());
					list.add(ci);
				}
				session.setAttribute("list", list);
				session.setAttribute("count",count);
			}
			request.getRequestDispatcher("/showCart.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

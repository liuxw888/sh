package com.sh.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sh.entity.Order;
import com.sh.entity.OrderItem;
import com.sh.entity.Page;
import com.sh.entity.Product;
import com.sh.entity.ProductType;
import com.sh.entity.User;
import com.sh.product.dao.ProductTypeDao;
import com.sh.product.service.ProductService;
import com.sh.user.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private UserService userService;
	@Resource
	private ProductService productService;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping(value="/listProduct")
	public String listProduct(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		try {
			List<Product> list=productService.listAll();
			List<Product> list1=productService.listAllHot();
			List<Product> list3 = productService.listAllNew();
			request.setAttribute("products", list);
			request.setAttribute("products1", list1);
			request.setAttribute("products2",list3);
			return "shop";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/listProduct2")
	public String listProduct2(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		try {
			List<Product> list=productService.listAll();
			List<Product> list1=productService.listAllHot();
			List<Product> list3 = productService.listAllNew();
			request.setAttribute("products", list);
			request.setAttribute("products1", list1);
			request.setAttribute("products2",list3);
			return "listshop";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/listProductDescription")
	public String listProductDp(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		try {
			String id=request.getParameter("productid");
			Product p=productService.findProductById(Integer.parseInt(id));
			request.setAttribute("pro",p);
			return "/single";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String listProductType(Model model, HttpServletRequest request){
		List<ProductType> list=ptd.findAll();
		request.setAttribute("pts", list);
		return "addproduct";
	}
	@RequestMapping(value="/addProduct1")
	public void addProduct(Product p,@RequestParam("img") CommonsMultipartFile img,HttpServletResponse response) throws IOException{		
		System.out.println(img.getOriginalFilename());
		p.setListimg("images/"+img.getOriginalFilename());
		productService.addProduct(p);
		response.sendRedirect("addProduct");
	}
	@RequestMapping(value="/deleteProduct")
	public void deleteProduct(@RequestParam("id") Integer id,HttpServletRequest request,HttpServletResponse response){
		try {
			productService.deleteById(id);
			request.getRequestDispatcher("productpage").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/productpage")
	public String productPage(HttpServletRequest request){
		if(1==Integer.parseInt(request.getParameter("ac"))){
			//1、获取页码
			String pageNum = request.getParameter("pageNum");
			int num=0;
			if(pageNum==null || pageNum.equals("")){
				num=1;
			}else{
				num=Integer.parseInt(pageNum);
			}
			//2、根据页码查询相关数据
			int count = productService.findCount();
			List<Product> list=productService.findByPage(num, 3);
			Page<Product> p=new Page<Product>(num, 3);
			p.setList(list);
			p.setTotalCount(count);
			List<ProductType> list2=ptd.findAll();
			List<User> list1 = userService.listAllUser();
			request.setAttribute("pts", list2);
			request.setAttribute("users", list1);
			request.setAttribute("page", p);
			try{
				List<OrderItem> list3 = new ArrayList<OrderItem>();
				HttpSession session = request.getSession();
				Order c=(Order)session.getAttribute("Order");
				if(c!=null){
					Iterator i=c.container.values().iterator();
					int count1=0;
					while(i.hasNext()){
						OrderItem ci=(OrderItem)i.next();
						count1+=ci.getCount()*(ci.getProduct().getPrice());
						list3.add(ci);
					}
					session.setAttribute("list", list3);
					session.setAttribute("count",count1);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return "personal";
		}else{
			return "faile";
		}
	}
	@RequestMapping(value="/editProduct",method=RequestMethod.GET)
	public String toEditProduct(Model model,@RequestParam("id") Integer id,HttpServletRequest request){
		Product p=productService.findProductById(id);
		request.setAttribute("product", p);
		request.setAttribute("action", "edit");
		List<ProductType> list=ptd.findAll();
		request.setAttribute("pts", list);
		return "editproduct";
	}
	@RequestMapping(value="/editProduct",method=RequestMethod.POST)
	public void editProduct(Product p,@RequestParam("img") CommonsMultipartFile img,HttpServletRequest request,HttpServletResponse response) throws IOException{		
		try {
			System.out.println(img.getOriginalFilename());
			p.setListimg(new Date().getTime()+img.getOriginalFilename());
			productService.updateProduct(p);
			request.getRequestDispatcher("productpage").forward(request,response);
			//return "productlist";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
	}
}

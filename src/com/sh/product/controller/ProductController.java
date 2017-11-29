package com.sh.product.controller;

import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sh.entity.Page;
import com.sh.entity.Product;
import com.sh.entity.ProductType;
import com.sh.product.dao.ProductTypeDao;
import com.sh.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;
	@Resource
	private ProductTypeDao ptd;
	@RequestMapping(value="/listProduct")
	public String listProduct(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		try {
			List<Product> list=productService.listAll();
			request.setAttribute("products", list);
			return "shop";
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
		p.setListimg(new Date().getTime()+img.getOriginalFilename());
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
		request.setAttribute("page", p);
		return "productlist";
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

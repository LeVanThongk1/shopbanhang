package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.dao.ProductDao;
import com.tranphong.banhang.dao.impl.ProductDaoImpl;
import com.tranphong.banhang.model.Bill;
import com.tranphong.banhang.model.BillProduct;
import com.tranphong.banhang.model.Product;
@WebServlet(urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet{
	ProductDao productDao=new ProductDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid=req.getParameter("pid");
		Product product=productDao.getId(Integer.parseInt(pid));
		HttpSession session =req.getSession();
		Object obj=session.getAttribute("cart");
		if(obj==null)//tao moi
		{
			//tao mat hang
			BillProduct billProduct=new BillProduct();
			billProduct.setProduct(product);
			billProduct.setQuantity(1);
			billProduct.setUnitPrice(product.getPrice());
			//gio hang co nhieu maat hang
			Map<String,BillProduct> map=new HashMap<>();
			
			map.put(pid, billProduct);//them mat hang vao danh sach
			
			session.setAttribute("cart", map);
		}
		else {
			Map<String , BillProduct> map=(Map<String , BillProduct>)obj;
			BillProduct billProduct=map.get(pid);
			
			if(billProduct==null)
			{
				billProduct =new BillProduct();
				billProduct.setProduct(product);
				billProduct.setQuantity(1);
				billProduct.setUnitPrice(product.getPrice());
				
				map.put(pid, billProduct);
			}else {
				billProduct.setQuantity(billProduct.getQuantity()+1);
			}
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
	
	

}

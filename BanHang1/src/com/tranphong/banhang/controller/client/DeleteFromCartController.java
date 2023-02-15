package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.model.BillProduct;
@WebServlet(urlPatterns = {"/delete-from-cart"})

public class DeleteFromCartController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String key=req.getParameter("key");
		System.out.println(key);
		HttpSession session=req.getSession();
		Object obj =session.getAttribute("cart");
		
		if(obj!=null)
		{
			Map<String , BillProduct> map=(Map<String,BillProduct>)obj;
			map.remove(key);
			
			session.setAttribute("cart", map);
		}
		resp.setHeader("Refresh", "1");
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
}

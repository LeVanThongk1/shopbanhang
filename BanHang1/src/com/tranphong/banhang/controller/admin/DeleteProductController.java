package com.tranphong.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.ProductDao;
import com.tranphong.banhang.dao.impl.ProductDaoImpl;


@WebServlet(urlPatterns = {"/admin/product/delete"})
public class DeleteProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid=req.getParameter("pid");
		ProductDao productDao=new ProductDaoImpl();
		productDao.delete(Integer.parseInt(pid));
		resp.sendRedirect(req.getContextPath()+"/admin/product/search");
		
	}
	

}

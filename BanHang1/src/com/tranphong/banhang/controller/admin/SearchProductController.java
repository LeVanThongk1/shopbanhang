package com.tranphong.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.ProductDao;
import com.tranphong.banhang.dao.impl.ProductDaoImpl;
import com.tranphong.banhang.model.Product;

@WebServlet(urlPatterns = {"/admin/product/search"})
public class SearchProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao pDao=new ProductDaoImpl();
		List<Product> pList=pDao.search("");
		req.setAttribute("productList", pList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/product/searchProduct.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword=req.getParameter("keyword");
		ProductDao productDao=new ProductDaoImpl();
		List<Product>  productList=productDao.search(keyword);
		req.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/product/searchProduct.jsp");
		dispatcher.forward(req, resp);
	}
}

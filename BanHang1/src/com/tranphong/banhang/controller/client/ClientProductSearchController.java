package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.CategoryDao;
import com.tranphong.banhang.dao.ProductDao;
import com.tranphong.banhang.dao.impl.CategoryDaoImpl;
import com.tranphong.banhang.dao.impl.ProductDaoImpl;
import com.tranphong.banhang.model.Category;
import com.tranphong.banhang.model.Product;
@WebServlet(urlPatterns = {"/client/product/search"})
public class ClientProductSearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//mac dinh lay tat ca san pham
		ProductDao productDao=new ProductDaoImpl();
		List<Product> plist=productDao.search("");
		req.setAttribute("plist", plist);
		
		
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> categoryList=categoryDao.search("");
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/client/product/search-product.jsp");
		requestDispatcher.forward(req, resp);
	}
}

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
@WebServlet(urlPatterns = {"/search-categoryId"})
public class ClientProductSearchCatogeryController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String categoryId=req.getParameter("idCategory");
		
		//mâc dinh lay tat ca san pham
		ProductDao productDao=new ProductDaoImpl();
		List<Product> pList=productDao.search(Integer.parseInt(categoryId));
		req.setAttribute("plist", pList);
		
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> categoryList=categoryDao.search("");
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("views/client/product/search-product.jsp");
		dispatcher.forward(req, resp);
	}
}

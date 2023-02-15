package com.tranphong.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.CategoryDao;
import com.tranphong.banhang.dao.impl.CategoryDaoImpl;
import com.tranphong.banhang.model.Category;

@WebServlet(urlPatterns = {"/admin/category/search"})
public class SearchAdminCategoryController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> categoryList=categoryDao.search("");
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/category/searchCategory.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword=req.getParameter("keyword");
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> categoryList=categoryDao.search(keyword);
		req.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/category/searchCategory.jsp");
		dispatcher.forward(req, resp);
	}
}

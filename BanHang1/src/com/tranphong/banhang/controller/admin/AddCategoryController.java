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
@WebServlet(urlPatterns = {"/admin/category/add"})
public class AddCategoryController extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/category/addCategory.jsp");
			dispatcher.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name=req.getParameter("name");
			Category category=new Category();
			category.setName(name);
			CategoryDao categoryDao=new CategoryDaoImpl();
			categoryDao.add(category);
			
			resp.sendRedirect(req.getContextPath() + "/admin/category/search");
		}

}

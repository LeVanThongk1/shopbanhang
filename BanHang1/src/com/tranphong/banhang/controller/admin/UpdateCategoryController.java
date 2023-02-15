package com.tranphong.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.CategoryDao;
import com.tranphong.banhang.dao.impl.CategoryDaoImpl;
import com.tranphong.banhang.model.Category;
@WebServlet(urlPatterns = {"/admin/category/update"})
public class UpdateCategoryController extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String cid=req.getParameter("cid");
			CategoryDao categoryDao=new CategoryDaoImpl();
			Category category=categoryDao.getIdD(Integer.parseInt(cid));
			
			req.setAttribute("category", category);
			RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/category/updateCategory.jsp");
			dispatcher.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String id=req.getParameter("id");
			String name=req.getParameter("name");
			
			 System.out.println(id+name);
			Category category=new Category();
			category.setId(Integer.parseInt(id));
			category.setName(name);
			
			CategoryDao categoryDao=new CategoryDaoImpl();
			categoryDao.update(category);
			
			resp.sendRedirect(req.getContextPath()+"/admin/category/search");
			
		}
}

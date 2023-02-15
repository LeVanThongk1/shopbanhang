package com.tranphong.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.CategoryDao;
import com.tranphong.banhang.dao.impl.CategoryDaoImpl;
@WebServlet(urlPatterns = {"/admin/category/delete"})
public class DeleteCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid=req.getParameter("cid");
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.delete(Integer.parseInt(cid));
		resp.sendRedirect(req.getContextPath()+"/admin/category/search");
	}
}	

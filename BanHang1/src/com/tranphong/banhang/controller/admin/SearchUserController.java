package com.tranphong.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns = {"/admin/user/search"})
public class SearchUserController extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			UserDao userDao=new UserDaoimpl();
			List<User> userList=userDao.search("");
			req.setAttribute("users", userList);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/user/searchUser.jsp");
			dispatcher.forward(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String keyword =req.getParameter("keyword");
			UserDao userDao=new UserDaoimpl();
			List<User> userList=userDao.search(keyword);
			req.setAttribute("users", userList);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/user/searchUser.jsp");
			dispatcher.forward(req, resp);
		}
		

}

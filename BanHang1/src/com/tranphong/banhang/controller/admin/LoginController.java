package com.tranphong.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns = {"/login-admin"})
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code =req.getParameter("errCode");
		if(code!=null&&code.equals("100"))
		{
			req.setAttribute("msg", "tai khoan hoac mat khau bi sai");
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/login.jsp");
		dispatcher.forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		//tao session
		HttpSession session=req.getSession();
		System.out.println("seesion id: "+session.getId());
		
		UserDao userDao=new UserDaoimpl();
		 User user= userDao.getByUsername(username);
		
		if(user!=null&& user.getPassword().equals(password))
		{
			System.out.println("login thanh cong");
			session.setAttribute("loginUser", user);//luu doi tuong vao session
			//chuyen huong server tra ve cho client mot trang web duong dan khac
			//req.getContentPath:tenn root path(ten project)
			resp.sendRedirect(req.getContextPath()+"/admin/user/search");
		}
		else
		{
			System.out.println("dang nhap that bai");
			resp.sendRedirect(req.getContextPath()+"/login-admin?errCode=100");
		}
		
	}
	
}

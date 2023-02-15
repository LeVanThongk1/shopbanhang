package com.tranphong.banhang.controller.client;

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
@WebServlet(urlPatterns = {"/login-member"})
public class ClientLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code =req.getParameter("errorCode");
		if(code!=null&&code.equals("100"))
		{
			req.setAttribute("msg", "tai khoan hoac mat khau cua ban bi sai");
		}
		if(code!=null &&code.equals("400"))
		{
			req.setAttribute("msg","tai khoan cua ban da dang nhap nhieu lan.ban co the dang nhap vao databese de reset lai gia tri login couter" );
		}
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/client/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String passwod=req.getParameter("password");
		UserDao userDao=new UserDaoimpl();
		User user=userDao.getByUsername(username);
		if(user!=null &&user.getPassword().equals(passwod))
		{
			System.out.println("login thanh cong");
			if(user.getLoginCounter()<10)
			{
				HttpSession session=req.getSession();
				session.setAttribute("loginUser", user);
				resp.sendRedirect(req.getContextPath()+"/client/product/search");
			}
			else
			{
				System.out.println("ban danh nhap khac roi");
				resp.sendRedirect(req.getContextPath() + "/login-menber?errorCode=100");
			}
		}
		else
		{
			System.out.println("login fail");
			resp.sendRedirect(req.getContextPath() +"/login-member?errorCode=100");
		}
	}
}

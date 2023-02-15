package com.tranphong.banhang.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns = {"/register"})
public class ClientRegisterController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("views/client/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String age =req.getParameter("age");
		String username=req.getParameter("username");
		String image=req.getParameter("image");
		
		User user=new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setGender(gender);
		user.setImage(image);
		user.setUsername(username);
		user.setRole("ROLE-MEMBER");
		user.setPassword(password);
		
		UserDao userDao=new UserDaoimpl();
		userDao.add(user);
		
		//chuyen huong tra ve 1 duong dan
		//client sang 1 duong dan moi
		
		resp.sendRedirect(req.getContextPath()+"/loginSuccess");
	}
}

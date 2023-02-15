package com.tranphong.banhang.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
@WebServlet(urlPatterns = {"/admin/user/delete"})
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		UserDao userDao=new UserDaoimpl();
		userDao.delete(Integer.parseInt(uid));
		resp.sendRedirect(req.getContextPath()+"/admin/user/search");
	}
}

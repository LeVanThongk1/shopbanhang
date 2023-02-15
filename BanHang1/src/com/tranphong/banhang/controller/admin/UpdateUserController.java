package com.tranphong.banhang.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns  = {"/admin/user/update"})
public class UpdateUserController extends HttpServlet {
	UserDao userDao=new UserDaoimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		User user=userDao.get(Integer.parseInt(uid));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/user/updateUser.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");
		String image = req.getParameter("image");

		 System.out.println(name + username+gender+role);
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setAge(Integer.parseInt(age));
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setRole(role);
		user.setImage(image);

		userDao.update(user);

		resp.sendRedirect("/BanHang1/admin/user/search");
	}
}

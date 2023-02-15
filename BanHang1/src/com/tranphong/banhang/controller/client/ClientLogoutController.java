package com.tranphong.banhang.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns = {"/client/logout"})
public class ClientLogoutController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Object obj =session.getAttribute("loginUser");
		if(obj!=null)
		{
			System.out.println("destroy");
			User user =(User) obj;
			UserDao userDao =new UserDaoimpl();
			userDao.updateLoginCounter(user.getId(), user.getLoginCounter()-1);
			
		}//xoa do truong session
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/client/product/search");
		
	}
	
	
}

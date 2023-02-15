package com.tranphong.banhang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.model.User;

public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//doc sesion
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		System.out.println("session id : "+session.getId());
		
		Object obj=session.getAttribute("loginUser");
		
		if(obj!=null)
		{
			User user =(User) obj;
			System.out.println(user.getUsername());
			if(user.getRole().equals("ROLE_ADMIN"))
			{
				chain.doFilter(request, response);
			}
			else
			{
				resp.sendRedirect(req.getContextPath()+"/access-deny");
			}
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/login-admin");
			return;
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

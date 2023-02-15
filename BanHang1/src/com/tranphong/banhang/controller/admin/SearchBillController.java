package com.tranphong.banhang.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.BillDao;
import com.tranphong.banhang.dao.impl.BillDaoImpl;
import com.tranphong.banhang.model.Bill;
@WebServlet(urlPatterns = {"/admin/bills"})
public class SearchBillController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BillDao billDao=new BillDaoImpl();
		List<Bill> billList=billDao.getAll();
		req.setAttribute("billList", billList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/bill/searchBill.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyword=req.getParameter("keyword");
		BillDao billDao=new BillDaoImpl();
		Bill bill= billDao.get(Integer.parseInt(keyword));
		req.setAttribute("bill", bill);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/bill/searchBill.jsp");
		dispatcher.forward(req, resp);
		
	}
}

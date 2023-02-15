package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.BillDao;
import com.tranphong.banhang.dao.BillDaoProduct;
import com.tranphong.banhang.dao.impl.BillDaoImpl;
import com.tranphong.banhang.dao.impl.BillProductDaoImpl;
import com.tranphong.banhang.model.Bill;
import com.tranphong.banhang.model.BillProduct;
@WebServlet(urlPatterns = {"/member/bill-product"})
public class ClientBillProductController extends HttpServlet{
	
	BillDao billDao=new BillDaoImpl();
	BillDaoProduct billDaoProduct=new BillProductDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billId =req.getParameter("billid");
		int x=Integer.parseInt(billId);
		Bill bill=billDao.get(x);
		req.setAttribute("bill", bill);
		
		List<BillProduct> billProduct=billDaoProduct.search(Integer.parseInt(billId));
		req.setAttribute("billProducts", billProduct);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/client/bill/bill-product.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}

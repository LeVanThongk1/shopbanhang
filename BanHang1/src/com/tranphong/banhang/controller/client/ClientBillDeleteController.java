package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tranphong.banhang.dao.BillDao;
import com.tranphong.banhang.dao.BillDaoProduct;
import com.tranphong.banhang.dao.impl.BillDaoImpl;
import com.tranphong.banhang.dao.impl.BillProductDaoImpl;
import com.tranphong.banhang.model.BillProduct;
@WebServlet(urlPatterns = {"/member/bill/delete"})
public class ClientBillDeleteController extends HttpServlet {
	BillDaoProduct billDaoProduct=new BillProductDaoImpl();
	BillDao billDao=new BillDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billId=req.getParameter("billid");
		
		//xoa het cac mat hang torng billproduc roi sau do moi xoa bill
		
		List<BillProduct> billProducts=billDaoProduct.search(Integer.parseInt(billId));
		for(BillProduct billProduct: billProducts)
		{
			billDaoProduct.delete(billProduct.getId());
		}
		billDao.delete(Integer.parseInt(billId));
		resp.sendRedirect(req.getContextPath()+"/member/bills");
	}
}

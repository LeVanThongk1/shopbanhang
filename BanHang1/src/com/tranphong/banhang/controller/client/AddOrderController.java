package com.tranphong.banhang.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tranphong.banhang.dao.BillDao;
import com.tranphong.banhang.dao.BillDaoProduct;
import com.tranphong.banhang.dao.impl.BillDaoImpl;
import com.tranphong.banhang.dao.impl.BillProductDaoImpl;
import com.tranphong.banhang.model.Bill;
import com.tranphong.banhang.model.BillProduct;
import com.tranphong.banhang.model.User;
@WebServlet(urlPatterns = {"/member/add-order"})
public class AddOrderController extends HttpServlet {
	
	BillDao billDao=new BillDaoImpl();
	BillDaoProduct billDaoProduct=new BillProductDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doc session tu gio hang ra truoc
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("cart");
		System.out.println(obj);
		
		
		 if(obj!=null)//kiem tra xem co sp co trong gio hang ko
		{
			Map<String , BillProduct> map=(Map<String, BillProduct>)obj;
			
			//tao hoa don truoc,de lay dc id bill
			Bill bill=new Bill();
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			bill.setBuyDate(sdf.format(new Date()));
			
			//laay dang nhap
			User buyer=(User) session.getAttribute("loginUser");
			bill.setBuyer(buyer);
			//xem them o lop billdao,cach tra ve id tu gen sql
			billDao.create(bill);//save bill truoc de lay id 
			
			//tim mat hang
			long total=0;//tinh tong gia
			
			///lap cac phan tu trong map 
			
			for(Entry<String, BillProduct> entry: map.entrySet())
			{
				BillProduct billProduct=entry.getValue();
				billProduct.setBill(bill);//set bill id vao day
				//luu lai cac mat hang
				billDaoProduct.create(billProduct);
				//tinh tong gia
				total+=billProduct.getQuantity()*billProduct.getUnitPrice();
			}
			//cap nhat lai bill de co tong gia tien
			bill.setPriceTotal(total);
			billDao.update(bill);
			
			//chuyen ve trang thanh cong
			//xoa session gio hang da atao don hang thanh cong ,giai phong bo nho
			session.removeAttribute("cart");
			resp.sendRedirect(req.getContextPath()+"/member/bills");
			
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/client/product/search");
		}
	}
	


}

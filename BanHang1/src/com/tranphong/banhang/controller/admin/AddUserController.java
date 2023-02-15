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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tranphong.banhang.dao.UserDao;
import com.tranphong.banhang.dao.impl.UserDaoimpl;
import com.tranphong.banhang.model.User;

@WebServlet(urlPatterns = {"/admin/user/add"})
public class AddUserController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/views/admin/user/addUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//tao doi tuong de luu tam thoi file upload len vao
			DiskFileItemFactory factory = new DiskFileItemFactory();

			/// doi thanh duong dan toi thu muc, luu tam thoi file upload len
			factory.setRepository(new File("E:\\Git-hub\\class-javaeweb12.wiki\\class-javaweb12\\JAVAWEB\\BanHang1\\WebContent\\image"));
			///TREN WINDOW THI D:\\files (thu muc files trong o D)

			//nho truyen factory vao consrtuctor
			// doc request tu client gui len trong form upload
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			/// danh sach cac truong input tu form client
			// duoc goi la fileitem
			List<FileItem> fieldList = servletFileUpload.parseRequest(req);

			User user = new User();
			// lay ra tung input
			for (FileItem item : fieldList) {
				System.out.println("1");
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					user.setName(name);
				}
				System.out.println("2");
				if (item.getFieldName().equals("age")) {
					String age = item.getString();
					user.setAge(Integer.parseInt(age));
				}
				System.out.println("3");
				if (item.getFieldName().equals("username")) {
					String username = item.getString();
					user.setUsername(username);
				}
				System.out.println("4");
				if (item.getFieldName().equals("password")) {
					String password = item.getString();
					user.setPassword(password);
				}
				if(item.getFieldName().equals("role"))
				{
					String role=item.getString();
					user.setRole(role);
				}
				
				
				System.out.println("5");
				if (item.getFieldName().equals("imageFile")) {
					//kiem tra dung luong file upload
					if (item.getSize() > 0) {//neu co upload file
						final String UPLOAD_FOLDER = "E:\\Git-hub\\class-javaeweb12.wiki\\class-javaweb12\\JAVAWEB\\BanHang1\\WebContent\\image\\user";
						//tao 1 file tren server
						//tim dinh dang file
						String name = item.getName();//tra ve ten file upload
						int index = name.lastIndexOf(".");
						String ext = name.substring(index);//lay ra phan dinh dang file
						
						//MINH se ko lay ten file anh upload len, vi se xay ra trung ten
						// ma tao 1 file ten moi
						///tao file de luu tren server
						String image = System.currentTimeMillis() + ext;//ten file anh moi
						File file = new File(UPLOAD_FOLDER + File.separator + image);
						
						//ghi du lieu upload len vao file
						item.write(file);
						String link="/BanHang1/image/user/"+image;
						user.setImage(link);//luu lai ten file anh vao product
					}
				}
				if(item.getFieldName().equals("gender"))
				{
					String gender=item.getString();
					user.setGender(gender);
				}
			}

			System.out.println("6");
			UserDao userDao = new UserDaoimpl();
			userDao.add(user);
		
		resp.sendRedirect(req.getContextPath()+"/admin/user/search");
	}
		catch (Exception e) {
			System.out.println("Loi " + e);
		}

}
}

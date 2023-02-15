<%@page import="com.tranphong.banhang.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/BanHang1/style/css/client/search-product.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
	
</head>
<body>
	
		<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
	
		<!-- tim kiem -->

		
		<div  id="tim" class="container">
				
				<div>
					<select>
						<option>idProduct</option>
						<option>CategoryId</option>
						<option>NameProduct</option>
					</select>
				</div>
				<div>
				
				<form action="/BanHang1/search-categoryId" method="post">
				<input type="text" name="idCategory" id="nhap" placeholder="nhap tim kiem">
					<input type="submit" value="Search" id="nut">
					</form>
				</div>
				<div>
				<i class="fas fa-cart-plus" id="Cart"></i>
				</div>
		</div>
	
	
	<div class="container">
		<h2>Danh sach san pham</h2>
	

		<table id="table-Product">
			<tr id=first-line">
				<th>ID</th>
				<th> NAME</th>
				<th>IMAGE </th>
				<th>PRICE</th>
				<th>DESCRIPTION</th>
				<th>ADD TO CART</th>
			</tr>
			
			
			<c:forEach items="${plist}" var="p">
			<tr id="second-line">
					<td >${p.id }</td>
					
					<td>${p.name }</td>
					<td><img src="${p.image }"></td>
					<td>${p.price }</td>
					<td>${p.description }</td>
					<td>
					<a href="/BanHang1/add-to-cart?pid=${p.getId()}">ADD TO CART</a>
					</td>
				
			</tr>
			</c:forEach>
		</table>
		
	</div>
	


</body>
</html>
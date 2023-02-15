<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/BanHang1/style/css/client/search-product.css">
</head>
<body>
	<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
	
	<div class="container">
		<h2>XEM CHI TIET SAN PHAM</h2>
	

		<table id="table-Product">
			<tr id=first-line">
				<th>ID</th>
				<th> SAN PHAM</th>
				<th>IMAGE </th>
				<th>SO LUONG</th>
				<th>DON GIA</th>
				<th>TONG TIEN</th>
			</tr>
			
			
			<c:forEach items="${billProducts}" var="billProduct">
			<tr id="second-line">
					<td >${billProduct.id }</td>
					
					<td>${billProduct.product.name }</td>
					<td><img src="${billProduct.product.image }"></td>
					<td>${billProduct.quantity }</td>
					<td>${billProduct.unitPrice }</td>
					<td>${billProduct.unitPrice* billProduct.quantity }</td>
				
			</tr>
			</c:forEach>
		</table>
	
</body>
</html>
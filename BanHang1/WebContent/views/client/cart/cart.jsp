<%@page import="com.tranphong.banhang.model.BillProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/BanHang1/style/css/client/search-product.css">
<title>Insert title here</title>
<style type="text/css">
	.container{
		width:1140px;
		margin: 0px auto;
		padding:0px 15px;
	}
		.container table {
	margin-top:100px;
	
}
.container  tr {
	border: 1px solid black;
	height: 30px;
	width:500px;
}
.container  tr th {
	border: 1px solid black;
	height: 30px;
	width:500px;
}
.container  tr td {
	border: 1px solid black;
}
.container tr td img{
	display: inline-block;
	height: 200px;
	width: 150px;
}
#hoadon{
	padding-top:30px;
	padding-left: 550px;
}
#hoadon a{
	text-decoration: none;
	border: 1px solid black;
	font-size: 18px;
	text-transform: uppercase;
	color: red;
	border-radius: 3px;
	background: #ebebeb;
	
	}
#hoadon a:hover{
	background: black;
	color:white;
}
h1{
	color: red;
	text-align: center;
	margin-bottom: 50px;
	margin-top: 20px;
}
	</style>
</head>
<body>
	<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
	
	<h1>thong tin don hang</h1>
	<table id="table-Product" class="container">
			<tr id=first-line">
				<th>ID</th>
				<th> TEN SP</th>
				<th>ANH </th>
				<th>GIA CA</th>
				<th>SO LUONG</th>
				<th>TONG TIEN</th>
				<th>LUA CHON</th>
				
			</tr>
			<%
				
				Object obj=session.getAttribute("cart");
			System.out.println(obj);
			
			%>
			
			<c:forEach items="${sessionScope.cart}" var="entry">
			<tr id="second-line">
					<td >${entry.key}</td>
					<td>${entry.value.product.name }</td>
					
					<td><img src="${entry.value.product.image }"></td>
					<td>${entry.value.quantity }</td>
					<td>${entry.value.unitPrice}</td>
					<td>${entry.value.quantity* entry.value.unitPrice}</td>
					<td>
					<a href="/BanHang1/delete-from-cart?key=${entry.key}">XOA</a>
					</td>
				
			</tr>
			</c:forEach>
		</table>
		
		<div id="hoadon">
			<a href="/BanHang1/member/add-order">Thanh Toan</a>
		</div>
</body>
</html>
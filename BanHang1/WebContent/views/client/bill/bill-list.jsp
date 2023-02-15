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
h2{
	color: red;
	text-align: center;
	margin-bottom: 50px;
	margin-top: 20px;
}
</style>
</head>
<body>
<jsp:include page="/views/client/common/menu.jsp"></jsp:include>
<h2>thong tin don hang</h2>
<table class="container">
	<tr>
	<th>Id</th>
	<th>Nguoi mua</th>
	<th>Ngay mua</th>
	<th>Tong tien</th>
	<th>Lua chon</th>
	</tr>
	
	<c:forEach  items="${bills}" var="bill">
		<tr>
			<td>${bill.id }</td>
			<td>${bill.buyer.name }</td>
			<td>${bill.buyDate }</td>
			<td>${bill.priceTotal }</td>
			<td><a href="/BanHang1/member/bill-product?billid=${bill.id }">Xem chi tiet</a>|
			<a href="/BanHang1/member/bill/delete?billid=${bill.id }">Xoa don</a>
			
			</td>
		
		</tr>
		
	</c:forEach>
	
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List User</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				
				<form class="form-inline" action="/BanHang1/admin/bills" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Nguoi mua</th>
						<th>Ngay mua</th>
						<th>Tong tien</th>
						<th>lua chon </th>
						
					</tr>
					<tr>
						<c:forEach items="${billList }" var="bill">
							<tr>
								<td>${bill.id }</td>
								<td>${bill.buyer.name }</td>
								<td>${bill.buyDate }</td>
								<td>${bill.priceTotal }</td>
								
								<td><a class="btn btn-success" href="/BanHanng1/admin/user/update?uid=${ user.getId()}">Sua</a> | <a class="btn btn-danger"
									href="/BanHang1/admin/user/delete?uid=${ user.getId()}">Xoa</a></td>
							</tr>
						</c:forEach>
						</tr>
						
						<c:if test="${bill!=null }">
							<tr>
								<td>${bill.id }</td>
								<td>${bill.buyer.name }</td>
								<td>${bill.buyDate }</td>
								<td>${bill.priceTotal }</td>
								
								<td><a class="btn btn-success" href="/BanHanng1/admin/user/update?uid=${ user.getId()}">Sua</a> | <a class="btn btn-danger"
									href="/BanHang1/admin/user/delete?uid=${ user.getId()}">Xoa</a></td>
							</tr>
						</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/views/admin/common/cssjs.jsp"></jsp:include>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<jsp:include page="/views/admin/common/menu.jsp"></jsp:include>
			</div>
			<div class="col-md-9 col-sm-12">
				<a href="/BanHang1/admin/category/add" class="btn btn-primary">Them moi</a>
				<form class="form-inline" action="/BanHang1/admin/category/search" method="post">
					<input class="form-control" name="keyword" type="text" placeholder="Tim theo ten">
					<button type="submit" class="btn btn-danger">Tim</button>
				</form>
				<table class="table table-hover">
					<tr class="table-header">
						<th>ID</th>
						<th>Name</th>
						
					</tr>
					<tr>
						<c:forEach items="${categoryList }" var="cList">
							<tr>
								<td>${cList.id }</td>
								<td>${cList.name }</td>
								
								<td><a class="btn btn-success" href="/BanHang1/admin/category/update?cid=${ cList.getId()}">Sua</a> | <a class="btn btn-danger"
									href="/BanHang1/admin/category/delete?cid=${ cList.getId()}">Xoa</a></td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="header">
			<div class="container">
				<div >
					<ul >
						<li><a>Kenh nguoi ban</a></li>
						<li><a>Tai ung dung</a></li>
						<li><a>Ket noi</a></li>
					</ul>
				</div>	
				
				<div id="2">
					<ul >
						<li><a>Thong bao</a></li>
						<li><a>Tro giup</a></li>
						<c:if test="${sessionScope.loginUser!=null }">
							<li><a>Xin chao ${sessionScope.loginUser.name }</a></li>
							<li><a href="/BanHang1/client/logout">Thoat</a></li>
							<li><a href="/BanHang1/member/bills">Don hang</a></li>
						</c:if>
						<c:if test="${sessionScope.loginUser==null }">
						<li><a href="/BanHang1/register">dang  ki </a></li>
						<li><a href="/BanHang1/login-member">dang nhap</a></li>
						</c:if>
					</ul>
				</div>	
				
			</div>
		</div>
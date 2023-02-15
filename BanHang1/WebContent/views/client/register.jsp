<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    .container {
        width: 600px;
        height: 500px;
        margin: 0px auto;

    }
    #dangnhapne {
        background-color: #72ee55;
        padding: 20px;
        width: 100%;
        border: 5px solid black;
        border-radius: 20px;
    }
    #dangnhapne div label{
        display: block;
        font-size: 20px;
        text-transform: uppercase;
        font-weight: bold;
        height: 30px;
		
     }
     #dangnhapne div input{
        display: inline-block;
        font-size: 20px;
        height: 30px;
        width:100%;
     }
      #dangnhapne  .nut{
      margin-top:20px;
      	display: inline-block;
      	text-align: center;
      }
      #dangnhapne  .nut input{
        display: inline-block;
        font-size: 20px;
        margin-right:30px;
        height: 40px;
        width:150px;
     }
     #dangnhapne  .nut input:hover{
     	background: #ebebeb;
     }
     h1{
     	margin:30px;
     	text-align:center;
     	text-transform: uppercase;
     	color: red;
     	font-weight: bold;
     	font-size: 30px;
     }
     .nut a{
      display: inline-block;
        font-size: 20px;
        margin-right:30px;
        height: 40px;
        width:150px;
        border: 1px solid black;
        background: #ebebeb;
        text-decoration: none;
        border-radius:3px; 
        margin-bottom: 40px;
        line-height: 40px;
     }
     .nut a:hover{
     		background: gray;
     }
</style>
</head>
<body>
	<h1>dang ki tai khoan</h1>
<div id="dang ki" class="container">
    <form action="/BanHang1/register" method="POST"  id="dangnhapne">
        <div>
            <label for="">Ho va ten</label>
            <input type="text" name="name">
        </div>
        <div>
            <label for="">tuoi</label>
            <input type="text" name="age">
        </div>
        <div>
            <label for="">Tai khoan</label>
            <input type="text" name="username">
        </div>
        <div>
            <label for="">Mat khau</label>
            <input type="text" name="password">
        </div>
        <div>
            <label for="">gioitinh</label>
            <input type="text" name="role">
        </div>
        <div>
            <label for="">Anh url: </label>
            <input type="text" name="image">
        </div>
       <div class="nut">
          <input type="submit" value="dang ki"> 
       </div>
       <div class="nut">
           <a href="/BanHang1/login-member">dang nhap</a>
       </div>
    </form>


</div>
</body>
</html>
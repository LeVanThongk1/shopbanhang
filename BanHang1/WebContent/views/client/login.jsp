<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<style>
   *{
        margin:0;
        padding:0;
        box-sizing:border-box;
    }
    #dangnhap {
        width:500px;
        margin:0px auto;
        border:1px solid black;
        padding:20px;
        background-color: #ebebeb;
    }
    #user {
        display:block;
        width:100%;
        padding-bottom:20px;

    }
     label {
        font-size:25px;
        line-height:30px;
        height:30px;
        
    }
    #user input {
        margin-top:10px;
       width:100%;
       display:inline-block;
       height:30px;
       
    }
    #pass {
        display:block;
        width:100%;
        padding-bottom:20px;

    }

    #pass input {
        margin-top:10px;
       width:100%;
       display:block;
       height:30px;
       
    }
   
    
    button {
        margin-top:30px;
        display:inline-block;
        height:30px;
        width:120px;
        margin-right: 50px;
        color: black;
    }
    a{
        text-decoration: none;
        color: black;
    	border: 1px solid black;
    	font-size: 14px;
    	line-height: 26px;
    	background-color: #ebebeb;
    	display: inline-block;
    	height: 30px;
    	width: 120px;
    	border-radius: 3px ;
    	margin-bottom: 30px;
    	
    	text-align: center;
    }
    a:hover{
    	background-color:#ebebeb;
    }
</style>
</head>
<body>
	
    <div id="dang-nhap" class="container">
        <form action="/BanHang1/login-member" method="post">
            <div id="dangnhap">
                <div id="user">
                    <label for="">username</label> <input type="text" name="username" id="username">
                </div>
                <div id="pass">
                   <label for="">password</label> <input type="password" name="password" id="password">
                </div>
                
                <button type="submmit" name="dangnhap" value="x">Dang nhap</button>
                <a href="#">Dang ki</a>
            </div>
          
        </form>
</body>
</html>
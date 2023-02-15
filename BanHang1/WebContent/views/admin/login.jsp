<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
     <meta charset="UTF-8">

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
        
    }
</style>
</head>
<body>
    
    <div id="dang-nhap" class="container">
        <form action="/BanHang1/login-admin" method="post">
            <div id="dangnhap">
            	<h3>${msg}</h3>
                <div id="user">
                    <label for="">username</label> <input type="text" name="username" id="username">
                </div>
                <div id="pass">
                   <label for="">password</label> <input type="password" name="password" id="password">
                </div>
                
                <button type="submmit" value="dangnhap">Dang nhap</button>
                
            </div>
          
        </form>
</div>
</body>
</html>
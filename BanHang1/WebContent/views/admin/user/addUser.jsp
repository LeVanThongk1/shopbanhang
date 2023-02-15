<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD USER</title>
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
     #dangnhapne div .chung{
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
    
     #gioitinh  label {
    display: inline-block;
    font-size: 20px;
    text-transform: uppercase;
    font-weight: bold;
    height: 30px;
}
	#gioitinh  input{
		display: inline-block;
	}
</style>
</head>
<body>
	<h1>dang ki tai khoan</h1>
<div id="dang ki" class="container">
    <form action="/BanHang1/admin/user/add" method="POST"  id="dangnhapne" enctype="multipart/form-data">
        <div>
            <label for="">Ho va ten</label>
            <input type="text" name="name" class="chung">
        </div>
        <div>
            <label for="">tuoi</label>
            <input type="text" name="age" class="chung">
        </div>
        <div>
            <label for="">Tai khoan</label>
            <input type="text" name="username" class="chung">
        </div>
        <div>
            <label for="">Mat khau</label>
            <input type="password" name="password" class="chung">
        </div> 
        	<div id="gioitinh" >
						<label>Gender : </label>
							<label >Nam</label><input type="radio" name="gender" value="nam">
							<label ">Nu </label><input type="radio" name="gender" value="nu" >						
			</div>
					<div  >
						<label>Role: </label> <select name="role" class="form-control">
							
								<option value="ROLE_MEMBER">ROLE_MEMBER</option>
								<option value="ROLE_ADMIN" >ROLE_ADMIN</option>

						</select>
					</div>
        <div>
            <label for="">Anh url: </label>
            <input type="file" name="imageFile" accept="image/*">
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
<%@page import="constant.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>NvN-Login</title>

  <!-- Favicons -->
  <link href="<%=request.getContextPath() %>/templates/admin/img/favicon.png"  rel="icon">
  <link href="<%=request.getContextPath() %>/templates/admin/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="<%=request.getContextPath() %>/templates/admin/lib/bootstrap/css/bootstrap.min.css"  rel="stylesheet">
  <!--external css-->
  <link href="<%=request.getContextPath() %>/templates/admin/lib/font-awesome/css/font-awesome.css"  rel="stylesheet" >
  <!-- Custom styles for this template -->
  <link href="<%=request.getContextPath() %>/templates/admin/css/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/templates/admin/css/style-responsive.css"  rel="stylesheet">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
  <div id="login-page">
    <div class="container">
      <form class="form-login" action="<%=request.getContextPath()%>/auth/login" method="post">
        <h2 class="form-login-heading">Đăng nhập Admin</h2>
        <div class="login-wrap">
          <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập" autofocus required="required">
          <br>
          <input type="password" name="password" class="form-control" placeholder="Mật khẩu" required="required">
          <label class="checkbox">
          
            <span class="pull-right">
            <a data-toggle="modal" href="login.html#myModal"> Quên mật khẩu?</a>
            </span>
            </label>
          <button class="btn btn-theme btn-block" href="index.html" type="submit"><i class="fa fa-lock"></i> Đăng nhập</button>
          	<%
          		String mess="";
          		if(request.getParameter("msg")!=null){
          			mess = (String)request.getParameter("msg");
          		}
          		if(mess.equals(CommonConstant.ERROR)){
          	%>
          	<div class="alert alert-danger" role="alert">
				 Sai tên đăng nhập hoặc mật khẩu!
			</div>
			
			<%
          		}
			%>
          <hr>
        
        
        </div>
        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Forgot Password ?</h4>
              </div>
              <div class="modal-body">
                <p>Enter your e-mail address below to reset your password.</p>
                <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
              </div>
              <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                <button class="btn btn-theme" type="button">Submit</button>
              </div>
            </div>
          </div>
        </div>
        <!-- modal -->
      </form>
    </div>
  </div>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="<%=request.getContextPath() %>/templates/admin/lib/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/admin/lib/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  
   <script src="<%=request.getContextPath() %>/templates/admin/lib/jquery.backstretch.min.js"></script>
  <script>
    $.backstretch("<%=request.getContextPath() %>/templates/admin/img/login-bg.jpg", {
      speed: 500
    });
  </script>
</body>

</html>

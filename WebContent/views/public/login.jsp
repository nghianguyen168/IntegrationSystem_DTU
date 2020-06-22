<!DOCTYPE html>
<%@page import="model.User"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Human And Payroll Mannagement</title>

<!-- Favicons -->
<link
	href="<%=request.getContextPath() %>/templates/admin/img/favicon.png"
	rel="icon">
<link
	href="<%=request.getContextPath() %>/templates/admin/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath() %>/templates/admin/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="<%=request.getContextPath() %>/templates/admin/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath() %>/templates/admin/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/templates/admin/css/style-responsive.css"
	rel="stylesheet">

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
			
			<form class="form-login" action="<%=request.getContextPath()%>/login"
				method="post">
		
				<h2 class="form-login-heading">sign in now</h2>
			<%
				String username_fail="";
				String password_fail="";
				if(request.getAttribute("userFail")!= null){
					User user = (User) request.getAttribute("userFail");
					username_fail= user.getName();
					password_fail = user.getPassword();
				}
    			if(request.getParameter("msg")!=null){
    		%>
			<div class="alert alert-danger" role="alert">Wrong username or password!</div>
				<%
    				}
				%>
				<div class="login-wrap">
					<input type="text" pattern=".{3,}" required value="<%=username_fail %>"
						title="3 characters minimum" name="username" style="width: 280px;"
						class="form-control" placeholder="Username" autofocus required>
					<br> <input type="password"  required value="<%=password_fail %>"
						title="6 characters minimum" name="password" class="form-control"
						style="width: 280px; margin-top: 10px;" placeholder="Password"
						required> <label class="checkbox"> <span
						class="pull-right"> <a data-toggle="modal"
							href="login.html#myModal"> Forgot Password?</a>
					</span>
					</label>
					<button class="btn btn-theme btn-block" href="index.html"
						type="submit">
						<i class="fa fa-lock"></i> SIGN IN
					</button>
					<hr>
			</form>

				</div>
				<!-- Modal -->
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Forgot Password ?</h4>
							</div>
							<form id="reset" action="<%=request.getContextPath()%>/user/reset" method="post">
								<input type="text" name="rusername" style="width: 280px;"
								class="form-control" placeholder="Username" autofocus>
								
							<input type="emailfdfd" name="remail" style="width: 280px;"
								class="form-control" placeholder="Email" autofocus>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">Cancel</button>
								<button class="btn btn-theme" type="submit">Submit</button>
							</div>
							</form>
						</div>
					</div>
				</div>
				<!-- modal -->
			
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath() %>/templates/admin/lib/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath() %>/templates/admin/lib/bootstrap/js/bootstrap.min.js"></script>
	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/templates/admin/lib/jquery.backstretch.min.js"></script>
	<script>
    $.backstretch("<%=request.getContextPath() %>/templates/admin/img/nen.jpg", {
					speed : 500
				});
	</script>
</body>

</html>

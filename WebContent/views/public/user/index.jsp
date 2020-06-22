<%@page import="utils.DefineUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="/templates/admin/inc/header.jsp"%>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<%@ include file="/templates/admin/inc/navbar.jsp"%>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<%@ include file="/templates/admin/inc/leftbar.jsp"%>

		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<div class="content-panel">
					
					<table class="table table-striped table-advance table-hover">
						<%
						EmployeeDAO emDao = new EmployeeDAO();
					
					%>
						<h4>
							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
							User Management
						</h4>

						<%-- <header class="panel-heading wht-bg" style="margin-bottom: -30px;">
							<h4 class="gen-case" style="padding-bottom: 0px;">
								<a href="<%=request.getContextPath()%>/employee/add"
									style="margin-left: 10px;" type="button"
									class="glyphicon glyphicon-plus-sign btn btn-success"></a>

								<div class="input-append" style="float: right;">
									<form>
										<input type="text" class="form-control  "
											style="display: inline;" placeholder="Typing Employee name">
										<input style="" class=" btn btn-success" type="submit"
											value="Search">
									</form>
								</div>

							</h4>
						</header> --%>
					<a href="<%=request.getContextPath() %>/user/add" style="margin-left: 20px; margin-bottom: 10px;" type="button" class="btn btn-theme"><i class="fa fa-plus-circle" aria-hidden="true"></i> Add</a>
						
						<%
						String msg="";
						if(request.getParameter("msg")!=null){
							msg = request.getParameter("msg");
						}
						if(msg.equals("success")){
							
						
					%>
					<div class="alert alert-success" role="alert">
						 Add user successfully!
						</div>
					<%
						}
						if(msg.equals("reset")){
							
						
					%>
					<div class="alert alert-success" role="alert">
						 Reset password success, Please check your email!
						</div>
					<%
						}
					%>
						<hr>
						<thead>
							
							<tr>
								<th><i class="fa fa-bullhorn"></i> User ID</th>
								<th class="hidden-phone"><i class="fa fa-question-circle"></i>
									User Name</th>
								<th><i class="fa fa-bookmark"></i> Fullname</th>
								<th><i class="fa fa-bookmark"></i> Gmail</th>
								<th><i class="fa fa-bookmark"></i> Role</th>
								<th><i class=" fa fa-edit"></i> Action</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
						<%
							if(request.getAttribute("userList")!=null){
								List<User> userList = (List<User>)request.getAttribute("userList");
								if(userList.size()>0){
									for(User u:userList){
										
								
						%>
							<tr>
								<td class="hidden-phone"><%=u.getId() %></td>
								<td><a href=""><%=u.getUsername() %></a></td>
								<td><%=u.getFullname() %></td>
								<td><%=u.getEmail() %></td>
								<td><%=u.getRole().getRole_name() %></td>
								<td>
									<button class="btn btn-success btn-xs">
										<i class="fa fa-check"></i>
									</button>
									<button class="btn btn-primary btn-xs">
										<i class="fa fa-pencil"></i>
									</button>
									<button class="btn btn-danger btn-xs">
										<i class="fa fa-trash-o "></i>
									</button>
								</td>
							</tr>
								<%
									}
								}
							}
								%>
						</tbody>
					</table>
				</div>

			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<script>
	
			document.getElementById("alert").classList.add('active');
			document.getElementById("home").classList.remove("active");
		</script>mây
		<%@ include file="/templates/admin/inc/footer.jsp"%>
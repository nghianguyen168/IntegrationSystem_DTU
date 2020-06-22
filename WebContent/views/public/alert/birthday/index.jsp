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
					List<Employee> birthDayListT=null;
					if (request.getAttribute("empBirthdayList") != null) {
					 birthDayListT = (List<Employee>) request.getAttribute("empBirthdayList");
					%>
						<h4>
							<i class=""></i> <img style="width:  5%; height: 5%;" alt="" src="<%=request.getContextPath()%>/templates/admin/img/birthday.png"> <%=birthDayListT.size() %> Employee have birthday in
							this month
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
						<a style="margin-left: 10px;"
							href="<%=request.getContextPath()  %>/alert/send-gmail?function=birthday"
							type="button" class="btn btn-warning btn-sm"> <i class="fa fa-envelope" aria-hidden="true"></i>  
							Send congratulations email</a>
						<%
							String msg="";
							if(request.getParameter("msg")!=null){
								msg = request.getParameter("msg");
							}
							if(msg.equals(DefineUtil.SUCCESS)){
						%>
						<div class="alert alert-success" role="alert">Send notification success!</div>
							
							<%
							}							
							%>
						<hr>
						<thead>

							<tr>
								<th><i class="fa fa-bullhorn"></i> Employee Number</th>
								<th class="hidden-phone"><i class="fa fa-question-circle"></i>
									Employee Name</th>
								<th><i class="fa fa-bookmark"></i> Date Of Birtday</th>
								<th><i class=" fa fa-edit"></i> Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
								
									if (birthDayListT.size() > 0) {
										for (Employee emBirth : birthDayListT) {
											Calendar cal = Calendar.getInstance();
											int current_day = cal.get(Calendar.DATE);
											String birthDay_fomat = formatter.format(emBirth.getBirth_Day());
											int day_of_birthDay = emBirth.getBirth_Day().getDate();
											
							%>
							<tr>
								<td class="hidden-phone"><%=emBirth.getEmployee_ID()%></td>
								<td><a href="<%=request.getContextPath()%>/employee/detail?id=<%=emBirth.getEmployee_ID()%>"><%=emBirth.getFirst_Name() + " " + emBirth.getCurrent_Middle_Name() + " "
								+ emBirth.getLase_Name()%></a></td>
								<td><%=birthDay_fomat %></td>
								<%
									String tb=" ";
									if(day_of_birthDay-current_day>0){
										tb="Còn "+	(day_of_birthDay-current_day)+" ngày";
									}
									if(day_of_birthDay==current_day){
										tb="Sinh nhật vào ngày hôm nay!";
									}
									else {
										tb="Đã qua";
									}
									
								%>
								<td><span class="label label-info label-mini"><%=tb %></span></td>
								
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
		</script>
		<%@ include file="/templates/admin/inc/footer.jsp"%>
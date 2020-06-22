
<%@page import="model.User"%>
<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start-->
	<a href="<%=request.getContextPath() %>/index" class="logo"><b>Human<span>Payroll</span></b></a>
	<!--logo end-->
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav top-menu">
			
			<%
						EmployeeDAO employeeDAON = new EmployeeDAO();
						int sizeHiring = 0;
						List<Employee> hiringDayList= null;
						if(employeeDAON.getCurrentHiringAniList()!=null){
							hiringDayList = employeeDAON.getCurrentHiringAniList();
							sizeHiring = hiringDayList.size();	
						}
					%>
			<!-- inbox dropdown start-->
			<li id="header_inbox_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
					<i class="fa fa-briefcase"></i> <span class="badge bg-theme"><%=sizeHiring %></span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green"><%=sizeHiring %> employee have hiring anniversary today</p>
					</li>
					<%
						for(Employee employee:hiringDayList){
							
						
					%>
					<li><a href="<%=request.getContextPath()%>/employee/detail?id=<%=employee.getEmployee_ID()%>"> <span
							class="label label-danger"><i class="fa fa-bolt"></i></span>
							<%=employee.getFirst_Name()+" "+employee.getCurrent_Middle_Name()+" "+employee.getLase_Name() %> <span class="small italic"></span>
					</a></li>
					<%
						}
					%>
					<li><a href="index.html#">See all messages</a></li>
				</ul></li>
			<!-- inbox dropdown end -->
			<!-- notification dropdown start-->
				<%
						
						List<Employee> birthDayList =null;
						int size=0;
						if(employeeDAON.getCurentBirtdayList()!=null){
							birthDayList=employeeDAON.getCurentBirtdayList();
							size=birthDayList.size();
						}
					%>
			<li id="header_notification_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
					<i class="fa fa-birthday-cake"></i> <span class="badge bg-warning"><%=size %></span>
			</a>
				<ul class="dropdown-menu extended notification">
					<div class="notify-arrow notify-arrow-yellow"></div>
				
					<li>
						<p class="yellow"><%=size %> employee have birthday today</p>
					</li>
					<%
						for(Employee employee:birthDayList){
					%>
					<li><a href="<%=request.getContextPath()%>/employee/detail?id=<%=employee.getEmployee_ID()%>"> <span
							class="label label-danger"><i class="fa fa-bolt"></i></span>
							<%=employee.getFirst_Name()+" "+employee.getCurrent_Middle_Name()+" "+employee.getLase_Name() %> <span class="small italic"></span>
					</a></li>
					<%
						}
					%>
					<li><a href="index.html#">See all notifications</a></li>
				</ul></li>
			<!-- notification dropdown end -->
		</ul>
		<!--  notification end -->
	</div>
	
	<div class="top-menu">
		<ul class="nav pull-right top-menu">
			<%
					User userLogin =null;
					if(session.getAttribute("userLogin")!=null){
						userLogin = (User)session.getAttribute("userLogin");
					
				%>
			<li><h5
				
					style="color: white; margin-top: 22px; margin-right: 30px;">
					Xin chào,  <a href=""><%=userLogin.getFullname()%></a></h5></li>
			<li><a class="logout" href="<%=request.getContextPath()%>/logout">Logout</a></li>
			<%
					}
			%>
		</ul>

	</div>
</header>
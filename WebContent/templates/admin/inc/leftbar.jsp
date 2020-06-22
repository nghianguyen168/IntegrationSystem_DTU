<%@page import="model.User"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<p class="centered">
				<a href="profile.html"><img
					src="<%=request.getContextPath()%>/templates/admin/img/person.png"
					class="img-circle" width="120px"></a>
			</p>
			<h5 class="centered">Nghia Nguyen</h5>
			<li class="mt"><a id="home" class="active"
				href="<%=request.getContextPath()%>/index"> <i
					class="fa fa-dashboard"></i> <span>Homepage</span>
			</a></li>
			<%
				User userL= null;
				
				if(session.getAttribute("userLogin")!=null){
					userL =(User) session.getAttribute("userLogin");
				}
			%>
			<%
				if(userL.getRole().getRole_id()==1 || userL.getRole().getRole_id()==2){
			%>
			<li  class="sub-menu"><a id="report" href="javascript:;"> <i
					class="glyphicon glyphicon-info-sign"></i> <span>Report</span>
			</a>
				<ul class="sub">

					<li><a href="<%=request.getContextPath()%>/report/payrate">Pay Rates</a></li>
					<li><a href="<%=request.getContextPath()%>/report/vacation?con=all">Vacation</a></li>
					<li><a href="<%=request.getContextPath()%>/report/benefit">Benefit Plan</a></li>
				
				</ul>
			
			
			</li>
			<%
			}
			%>
			<%
				if(userL.getRole().getRole_id()==1 || userL.getRole().getRole_id()==2 || userL.getRole().getRole_id()==3){
			%>
			
			<li  class="sub-menu"><a  id="alert" href="javascript:;"> <i
					class="glyphicon glyphicon-bell"></i> <span >Alert </span>
			</a>
				<ul class="sub">
					<%
						EmployeeDAO eDAO = new EmployeeDAO();
					%>
					<li><a href="<%=request.getContextPath()%>/alert/hiring">Hiring Anniversary <span
							class="label label-theme pull-right mail-info"><%=eDAO.getHiringAniList().size()%></span></a></li>
					<li><a href="<%=request.getContextPath()%>/alert/vacation">Vocation Days <span
							class="label label-theme pull-right mail-info"><%=eDAO.getOutVacation().size()%></span></a></li>
					<%
						int sum_birthday=0;
						EmployeeDAO employeeDAO = new EmployeeDAO();
						if(employeeDAO.getBirtdayList()!=null){
							sum_birthday = employeeDAO.getBirtdayList().size();
						}
					
					%>
					<li><a id="birthday" href="<%=request.getContextPath()%>/alert/birthday">Birthday <span
							class="label label-theme pull-right mail-info"><%=sum_birthday %></span></a></li>
					<li><a href="<%=request.getContextPath()%>/alert/benefit">Benifit Plan <span
							class="label label-theme pull-right mail-info"><%=eDAO.getEmBenefitList().size() %></span></a></li>
				</ul></li>
				<%
					}
				%>
			<%
				if(userL.getRole().getRole_id()==1 ){
			%>
				<li ><a id="user" 
				href="<%=request.getContextPath()%>/user"> <i
					class="fa fa fa-user"></i> <span>User</span>
			</a></li>
			<%
				}
			%>
			</li>
	</div>
</aside>
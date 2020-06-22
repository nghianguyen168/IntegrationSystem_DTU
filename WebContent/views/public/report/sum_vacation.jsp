
<%@page import="model.VacationCondition"%>
<%@page import="utils.DefineUtil"%>
<%@page import="dao.PersonalDAO"%>
<%@page import="model.Personal"%>
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
		
				<div class="showback">
					<h2 style="text-align: center; font-weight: bold; color: #4ECDC4;">
						Total number of vacation days	</h2>
					<h4>
						<i class="fa fa-angle-right"></i> Select type of summarized information
					</h4>
					
					<!-- Split button -->
					<div class="btn-group">
						<button type="button" class="btn btn-theme dropdown-toggle"
							data-toggle="dropdown" aria-expanded="false">
							Total <span class="caret"></span>
						</button>
						
						<ul class="dropdown-menu" role="menu">
							<li><a href="<%=request.getContextPath()%>/report/vacation?con=gender">Gender</a></li>
							<li><a href="<%=request.getContextPath()%>/report/vacation?con=dt">Ethnicity</a></li>
							<li><a href="<%=request.getContextPath()%>/report/vacation?con=department">Department</a></li>
							
						</ul>
					</div> 
				</div>
				<div class="row">
					
					<%
						if(request.getAttribute("vCondition")!=null){
							List<VacationCondition> vCondition =(List<VacationCondition>) request.getAttribute("vCondition");
							if(vCondition.size()>0){
								for(VacationCondition vCondition2:vCondition){
									
							
					%>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="custom-box">
								<div class="servicetitle">
									<h4><%=vCondition2.getName() %></h4>
									<hr>
								</div>
								<div class="icn-main-container">
									<span class="icn-container"><%=vCondition2.getValue() %> Day 	</span>
								</div>
								<p>Total earnings of <%=vCondition2.getName()%> employee</p>
								
								
							</div>
							
						</div>
						<%
								}
							}
							}
						%>
						
					</div>
					<!--  /col-lg-12 -->
				</div>
				<!--  /row -->


			</section>

			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<script>
	
			document.getElementById("report").classList.add('active');
			document.getElementById("home").classList.remove("active");
		</script>
		<%@ include file="/templates/admin/inc/footer.jsp"%>
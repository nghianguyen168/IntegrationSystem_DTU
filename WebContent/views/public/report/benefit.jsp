
<%@page import="model.BenefitReport"%>
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
			<h2 style="text-align: center; font-weight: bold; color: #4ECDC4;">
						Average Benefits</h2>
				
				<div class="row">
					
					<%
					String name="";
					int sh=0;
					int nonsh=0;
						if(request.getAttribute("benReports")!=null){
							List<BenefitReport> benReports =(List<BenefitReport>) request.getAttribute("benReports");
							if(benReports.size()>0){
								for(BenefitReport ben: benReports){
									if(ben.getStatus()==1){
										name = "ShareHolder";
										sh++;
									
									
							
					%>
						<div class="col-lg-6 col-md-4 col-sm-4 col-xs-12">
							<div class="custom-box">
								<div class="servicetitle">
									<h4><%=name %></h4>
									<hr>
								</div>
								<div class="icn-main-container">
									<span class="icn-container"><%=ben.getValue()/sh%> Day 	</span>
								</div>
								<p>Total earnings of <%=name%> employee</p>
								
								
							</div>
							
						</div>
						<%
									} else {
										name = "Non-ShareHolder";
										nonsh++;
									
						%>
						<div class="col-lg-6 col-md-4 col-sm-4 col-xs-12">
							<div class="custom-box">
								<div class="servicetitle">
									<h4><%=name %></h4>
									<hr>
								</div>
								<div style="width: 200px;" class="">
									<span class="icn-container"><%=ben.getValue()/nonsh%> Day 	</span>
								</div>
								<p>Total earnings of <%=name%> employee</p>
								
								
							</div>
							
						</div>
						<%
									}
								}
							}
							}
						%>
						
					</div>
					<!--  /col-lg-12 -->
				</div>
				<!--  /row -->




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
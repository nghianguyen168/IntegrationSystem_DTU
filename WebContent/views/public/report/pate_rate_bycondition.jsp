
<%@page import="model.PayCondition"%>

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
				<div class="showback">
				<h2 style="text-align: center; font-weight: bold; color: #4ECDC4;">
						Total Earning</h2>
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
							<li><a href="<%=request.getContextPath()%>/report/pay?con=gender">Gender</a></li>
							<li><a href="<%=request.getContextPath()%>/report/pay?con=dt">Ethnicity</a></li>
							<li><a href="<%=request.getContextPath()%>/report/pay?con=department">Department</a></li>
							
						</ul>
					</div> 
				</div>
				<div class="row">
					<!-- <div class="col-lg-12">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="custom-box">
								<div class="servicetitle">
									<h4>Standard</h4>
									<hr>
								</div>
								<div class="icn-main-container">
									<span class="icn-container">$25</span>
								</div>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. Lorem Ipsum has been the industry.</p>
								<ul class="pricing">
									<li>150 Mb Storage</li>
									<li>1 Domain</li>
									<li>2 Sub Domains</li>
									<li>3 MySQL DBs</li>
									<li>2 Emails</li>
									<li>WordPress Installation</li>
									<li>24/7 Support</li>
								</ul>
								<a class="btn btn-theme" href="#">Order Now</a>
							</div>
							end custombox
						</div> -->
						<!-- end col-4 -->
						<%
							if(request.getAttribute("payGenderList")!=null){
								List<PayCondition> payGenderList =(List<PayCondition>) request.getAttribute("payGenderList");
								if(payGenderList.size()>0){
									for(PayCondition pay:payGenderList){
										
								
						%>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
							<div class="custom-box">
								<div class="servicetitle">
									<h4><%=pay.getName() %></h4>
									<hr>
								</div>
								<div class="icn-main-container">
									<span class="icn-container">$<%=pay.getValue() %></span>
								</div>
								<p>Total earnings of <%=pay.getName() %> employee</p>
								
								
							</div>
							<!-- end custombox -->
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
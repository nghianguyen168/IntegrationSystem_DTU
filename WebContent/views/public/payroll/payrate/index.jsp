
<%@page import="model.Payrate"%>
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
						<h4>
							<i class="fa fa-angle-right"></i> Advanced Table
						</h4>
					
						<header class="panel-heading wht-bg" style="margin-bottom: -30px;">
							<h4 class="gen-case" style="padding-bottom: 0px;">
								<a href="<%=request.getContextPath() %>/payroll/payrate/add" style="margin-left: 10px;" type="button"
									class="glyphicon glyphicon-plus-sign btn btn-success"></a>
								
									<div class="input-append" style="float: right;">
									<form>
										<input type="text" class="form-control  " style="display: inline;"
											placeholder="Typing Employee name">
										<input style="" class=" btn btn-success" type="submit" value="Search">
									</form>
									</div>
								
							</h4>
						</header>
						<hr>
						<thead>

							<tr>
								<th><i class=fa"></i> Payrate ID</th>
								<th><i class=" "></i> Payrate Name</th>
								<th><i class=" "></i> Value</th>
								<th><i class=" "></i> Tax Parcentage</th>
								<th><i class=" "></i> Pay Type</th>
								<th><i class=" "></i> Pay Amount</th>
								<th><i class=""></i> PT Level C</th>
							</tr>
						</thead>
						<tbody>
						<%
							if(request.getAttribute("payRateList")!=null){
								List<Payrate> payRateList =(List<Payrate> ) request.getAttribute("payRateList");
								if(payRateList.size()>0){
									for(Payrate payrate:payRateList){
										
							
						%>
							<tr>
								<td><%=payrate.getIdPay_Rate() %></td>
								<td><%=payrate.getPay_Rate_Name() %></td>
								<td><%=payrate.getValue() %></td>
								<td><%=payrate.getTax_Percentage() %></td>
								<td><%=payrate.getPay_Type() %></td>
								<td><%=payrate.getPay_Amount() %></td>
								<td><%=payrate.getPt_Level_C() %></td>
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
		<%@ include file="/templates/admin/inc/footer.jsp"%>
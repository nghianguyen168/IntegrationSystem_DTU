
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
						<!-- <div>
							<div style="float: left;">

								<a style="margin-left: 10px;" type="button"
									class="glyphicon glyphicon-plus-sign btn btn-success"></a>
							</div>
							<div class="input-append" style="margin-right:">
								<input type="text" class="form-control "
									placeholder="Search Mail">
							</div>
						</div> -->
						<header class="panel-heading wht-bg" style="margin-bottom: -30px;">
							<h4 class="gen-case" style="padding-bottom: 0px;">
								<a href="<%=request.getContextPath() %>/employee/add" style="margin-left: 10px;" type="button"
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
								<th><i class="fa fa-bullhorn"></i> Company</th>
								<th class="hidden-phone"><i class="fa fa-question-circle"></i>
									Descrition</th>
								<th><i class="fa fa-bookmark"></i> Profit</th>
								<th><i class=" fa fa-edit"></i> Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><a href="basic_table.html#">Company Ltd</a></td>
								<td class="hidden-phone">Lorem Ipsum dolor</td>
								<td>12000.00$</td>
								<td><span class="label label-info label-mini">Due</span></td>
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
							<tr>
								<td><a href="basic_table.html#"> Dashio co </a></td>
								<td class="hidden-phone">Lorem Ipsum dolor</td>
								<td>17900.00$</td>
								<td><span class="label label-warning label-mini">Due</span></td>
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
							<tr>
								<td><a href="basic_table.html#"> Another Co </a></td>
								<td class="hidden-phone">Lorem Ipsum dolor</td>
								<td>14400.00$</td>
								<td><span class="label label-success label-mini">Paid</span></td>
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
							<tr>
								<td><a href="basic_table.html#">Dashio ext</a></td>
								<td class="hidden-phone">Lorem Ipsum dolor</td>
								<td>22000.50$</td>
								<td><span class="label label-success label-mini">Paid</span></td>
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
							<tr>
								<td><a href="basic_table.html#">Total Ltd</a></td>
								<td class="hidden-phone">Lorem Ipsum dolor</td>
								<td>12120.00$</td>
								<td><span class="label label-warning label-mini">Due</span></td>
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
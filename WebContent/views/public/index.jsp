
<%@page import="java.text.SimpleDateFormat"%>
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
					
					<table class="table table-striped table-advance table-hover">
						<h2 style="text-align: center; font-weight: bold; color: #4ECDC4;">
							HUMAN AND PAYROLL MANAGEMENT SYSTEM</h2>
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
						<%
						String msg = "";
						if(request.getParameter("msg")!=null){
							msg = request.getParameter("msg");
							
						}
						if(msg.equals("delok")){
							
						
					%>
					<div class="alert alert-success" role="alert">
					  Delete Successfully!
					</div>
					<%
						} 
						if(msg.equals("delerror")){
					%>
					<div class="alert alert-danger" role="alert">
					  Delete Error!
					</div>
					<%
						}
						if(msg.equals("success")){
					%>
					<div class="alert alert-success" role="alert">
					  Add Successfully!
					</div>
					<%
						}
					%>
						<header class="panel-heading wht-bg">
							<h4 class="gen-case" style="padding-bottom: 0px;">
								<a  href="<%=request.getContextPath()%>/employee/add"
									style="margin-left: 10px;" type="button"
									class="glyphicon glyphicon-plus-sign btn btn-success"></a>
									<%
									String search="";
									if(request.getAttribute("employeeName")!=null){
										search = (String)request.getAttribute("employeeName");
									}
									if(request.getParameter("result")!=null){
										
									
									%>
									<div class="alert alert-danger" role="alert">
									  No result for employe name "<%=search %>"
									</div>
									<%
									}
									%>
								<div class="input-append" style="float: right; margin-top: 10px;">
									<form action="<%=request.getContextPath()%>/employee/search" method="GET">
										<input type="text" value="<%=search %>" name="employee" class="form-control  "
											style="display: inline;" placeholder="Typing Employee name">
										<select class="form-control  " name="status">
											<option class="form-control  " value="1">ShareHolder</option>
											<option class="form-control  " value="0">Employee</option>
										</select>
										<input style="" class=" btn btn-success" type="submit"
											value="Search">
									</form>
								</div>

							</h4>
						</header>
						<hr>
						<thead>

							<tr>
								<th><i class="fa fa-bullhorn"></i> Employee ID</th>
								<th><i class="fa fa-bullhorn"></i> Employee Name</th>
								<th class="hidden-phone"><i class="fa fa-question-circle"></i>
									Date of Birth</th>
								<th><i class="fa fa-bookmark"></i> Gender</th>
								<th><i class="fa fa-bookmark"></i> Department</th>
								<th><i class="fa fa-bookmark"></i> Division</th>
								<th><i class=" fa fa-edit"></i> Country</th>
								<th><i class=" fa fa-edit"></i> Phone Number</th>
								<th><i class=" fa fa-edit"></i> Email</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
							int numberOfPages = 1;
							int curentPage = 1;
							int numberOfItems = DefineUtil.NUMBER_PER_PAGE;
							int offset = 0;
							if (request.getAttribute("offset") != null) {
								offset = (int) request.getAttribute("offset");
							}
							String searchText="";
							
							if(request.getAttribute("searchText")!=null){
								searchText = (String)request.getAttribute("searchText");
							}
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
							PersonalDAO personalDAO = new PersonalDAO();
							List<Personal> pListByAdmin=null;
							List<Personal> employeeSearch=null;
								if ( personalDAO.findAllByPage(offset)!= null) {
									pListByAdmin = personalDAO.findAllByPage(offset);
									if(request.getAttribute("employeeSearch")!=null){
										employeeSearch = (List<Personal>)request.getAttribute("employeeSearch");
										if(employeeSearch.size()>0){
											pListByAdmin = employeeSearch;
										}
									}
									if (pListByAdmin.size() > 0) {
										for (Personal em : pListByAdmin) {
							%>
							<tr>
								<td class="hidden-phone"><%=em.getEMPLOYEE_ID()%></td>
								<td><a href="<%=request.getContextPath()%>/employee/detail?id=<%=em.getEMPLOYEE_ID()%>"><%=em.getCURRENT_FIRST_NAME() + " " + em.getCURRENT_MIDDLE_NAME() + " "
								+ em.getCURRENT_LAST_NAME()%></a></td>
								<td class="hidden-phone"><%=formatter.format(em.getBIRTH_DATE()) %></td>
								<td><%=em.getCURRENT_GENDER()%></td>
								<td><%=em.getDEPARTMENT()%></td>
								<td><%=em.getDIVISION()%></td>
								<td><%=em.getCURRENT_COUNTRY()%></td>
								<td><%=em.getCURRENT_PHONE_NUMBER()%></td>
								<td><%=em.getCURRENT_PERSONAL_EMAIL()%></td>
								<td>
									
									<button class="btn btn-primary btn-xs">
										<i class="fa fa-pencil"></i>
									</button>
									<a onclick="return confirm('Are you sure you want to delete this employee?');" href="<%=request.getContextPath() %>/employee/del?id=<%=em.getEMPLOYEE_ID() %>" class="btn btn-danger btn-xs">
										<i class="fa fa-trash-o "></i>
									</a>
									
								</td>
								
							</tr>
							<%
								}
									
								}
							%>
						</tbody>

					</table>
					<%
										
										if (request.getAttribute("numberOfPages") != null) {
											numberOfPages = (int) request.getAttribute("numberOfPages");
										}
										if (request.getAttribute("curentPage") != null) {
											curentPage = (int) request.getAttribute("curentPage");
										}
										if (request.getAttribute("numberOfItems") != null) {
											numberOfItems = (int) request.getAttribute("numberOfItems");
										}
										
										
										if (request.getAttribute("numberOfPagesSearch") != null) {
											numberOfPages = (int) request.getAttribute("numberOfPagesSearch");
										}
										if (request.getAttribute("curentPageSearch") != null) {
											curentPage = (int) request.getAttribute("curentPageSearch");
										}
										if (request.getAttribute("numberOfItemsSearch") != null) {
											numberOfItems = (int) request.getAttribute("numberOfItemsSearch");
										}
										
										%>
					<!-- <div class="dataTables_paginate paging_bootstrap pagination">
						<ul>
							<li class="prev disabled"><a href="#">← Previous</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li class="next"><a href="#">Next → </a></li>
						</ul>
					</div> -->
					<div class="dataTables_paginate paging_bootstrap pagination">
									<div class="dataTables_paginate paging_simple_numbers"
										id="dataTables-example_paginate">
										<ul class="pagination">
											<%
												String url=request.getContextPath()+"/index?page="+(curentPage-1);
												if(employeeSearch!=null){
													url=request.getContextPath()+"/employee/search?employee="+searchText;
												} 
												if (numberOfPages >1) {
											%>
											<li class="" aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a
												href="<%=url%>">Trang
													trước</a></li>
											<%
												}
											%>

											<%
												String active = "";
													for (int i = 1; i <= numberOfPages; i++) {
														if (curentPage == i) {
															active = "active";
														} else {
															active = "";
														}
											%>
											<%
											String url1=request.getContextPath()+"/index?page="+i;
											if(employeeSearch!=null){
												url1=request.getContextPath()+"/employee/search?employee="+searchText;
											} 
											
											%>
											<li class="paginate_button <%=active%>"
												aria-controls="dataTables-example" tabindex="0"><a
												href="<%=url1%>"><%=i%></a></li>

											<%
												}
											%>
											<%
											String url2=request.getContextPath()+"/index?page="+(curentPage+1);
											if(employeeSearch!=null){
												url2=request.getContextPath()+"/employee/search?employee="+searchText;
											} 
												if (numberOfPages > 1) {
											%>
											<li class="paginate_button next"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a
												href="<%=url2%>">Trang
													tiếp</a></li>
											<%
												}
											%>
										</ul>
									</div>
								</div>
							</div>
							<%
								}
							%>
						</div>
				</div>

			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<%@ include file="/templates/admin/inc/footer.jsp"%>
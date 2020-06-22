
<%@page import="model.Benefit_Plan"%>
<%@page import="dao.Benefit_PlanDAO"%>
<%@page import="model.Job_History"%>
<%@page import="model.Personal"%>
<%@page import="java.util.Date"%>
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
				<div class="col-lg-12 mt">
					<div class="row content-panel">

						<!-- /panel-heading -->
						<div class="panel-body">
							<div class="tab-content">

								<!-- /col-md-6 -->


								<!-- /row -->

								<!-- /tab-pane -->

								<!-- /tab-pane -->
								<div class="tab">
									<div class="row">
										<div class="col-lg-12 col-lg-offset-0 detailed">
											<h4 class="mb">ADD NEW EMPLOYEE</h4>
											
											
											<%
												String em_Id="";
												String first_name="";
												String midle_name="";
												String last_name="";
												String address ="";
												String city="";
												String country="";
												String birthday="dd-mm-yyyy";
												String department="";
												String division="";
												String gender="";
												String phone="";
												String email="";
												String dantoc="";
												int sh=0;
												
												if(request.getAttribute("personal")!=null){
													Personal personal= (Personal)request.getAttribute("personal");
													em_Id = personal.getEMPLOYEE_ID();
													first_name=personal.getCURRENT_FIRST_NAME();
													midle_name=personal.getCURRENT_MIDDLE_NAME();
													last_name = personal.getCURRENT_LAST_NAME();
													address= personal.getCURRENT_ADDRESS_1();
													city = personal.getCURRENT_CITY();
													country = personal.getCURRENT_COUNTRY();
													birthday = personal.getBIRTH_DATE().toString();
													gender = personal.getCURRENT_GENDER();
													phone = personal.getCURRENT_PHONE_NUMBER();
													email = personal.getCURRENT_PERSONAL_EMAIL();
													dantoc = personal.getETHNICITY();
												}
												if(request.getAttribute("job_History")!=null){
													Job_History job_History= (Job_History)request.getAttribute("job_History");
													department = job_History.getDEPARTMENT();
													division = job_History.getDIVISION();
												}
												String msg="";
												if(request.getParameter("msg")!=null){
													msg = request.getParameter("msg");													
												}
												if("trung".equals(msg)){
												
											%>
											<div class="alert alert-danger" role="alert">
											  Employee ID is exist!
											</div>
											<%
											
												}
											%>
											<form action="<%=request.getContextPath() %>/employee/add" method="post" role="form" class="cmxform form-horizontal style-form">
											<div style="float: left; width: 500px; margin-left: 150px; ">
												<div class="form-group">
														<label class="col-lg-4 control-label">Employee ID
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=em_Id %>" placeholder=" " id="c-name" name="emid"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">First Name
															(required )</label>
														<div class="col-lg-6">
															<input value="<%=first_name %>" type="text" placeholder=" " id="c-name" name="firstname"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Midle Name
															(required )</label>
														<div class="col-lg-6">
															<input value="<%=midle_name %>" type="text" placeholder=" " id="c-name" name="midlename"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Last Name
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=last_name %>" placeholder=" " id="c-name" name="lastname"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Adress
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=address %>" placeholder=" " id="c-name" name="adress"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> City
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=city %>" placeholder=" " id="c-name" name="city"
																class="form-control" required="">
														</div>
													</div>
														<div class="form-group">
														<label class="col-lg-4 control-label"> Country
															(required )</label>
														<div class="col-lg-6">
															<input type="text" placeholder=" " value="<%=country %>" id="c-name" name="country"
																class="form-control" required="">
														</div>
													</div>
														<div class="form-group">
													<label class="col-lg-4 control-label">Date of birth
														(required )</label>
													<div class="col-lg-6">
														<input type="date"  name="birthday" class="form-control" id="start" name="trip-start" required
														value="<%=birthday %>" min="1970-01-01" max="2018-12-31"   data-bv-date="true"
									                data-bv-date-format="YYYY/MM/DD"
									                data-bv-date-message="The value is not a valid date" />
													</div>
												</div>
												
											</div>
											<div style="float: left; margin-left:50px; width: 500px; ">
											
												<div class="form-group">
														<label class="col-lg-4 control-label">Department
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=department %>"  placeholder=" " id="c-name" name="department"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Division
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=division %>" placeholder=" " id="c-name" name="division"
																class="form-control" required="">
														</div>
													</div>
												<div class="form-group">
														<label class="col-lg-4 control-label">Gender
															(required )</label>
														<div class="col-lg-6">
															<select class="form-control" required name="gender" >
																
																<option required value="Male">Male</option>
																<option required value="Female">FeMale</option>
															</select>
															
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">Phone Number
															(required )</label>
														<div class="col-lg-6">
															<input type="tel" value="<%=phone %>" pattern=".{10}" placeholder=" " id="c-name" name="phone"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Email
															(required )</label>
														<div class="col-lg-6">
															<input type="email" value="<%=email %>" placeholder=" " id="c-name" name="email"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label"> Ethnicity
															(required )</label>
														<div class="col-lg-6">
															<input type="text" value="<%=dantoc %>" placeholder=" " id="c-name" name="dantoc"
																class="form-control" required="">
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">ShareHolder Status
															(required )</label>
														<div class="col-lg-6">
															<select class="form-control" required name="sh" >
																<option required value="0">No</option>
																<option required value="1">Yes</option>
															</select>
															
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">Benefit Plan
															(required )</label>
														<div class="col-lg-6">
														<%
															Benefit_PlanDAO bDao = new Benefit_PlanDAO();
															List<Benefit_Plan> benList = bDao.findAll();
														%>
															<select class="form-control" required name="benefit" >
															<%
																if(benList.size()>0){
																for(Benefit_Plan benefit_Plan:benList){
															%>
																<option required value="<%=benefit_Plan.getBenefit_Plan_Id()%>"><%=benefit_Plan.getPlan_Name() %></option>
																
																<%
																	}}
																%>
															</select>
															
														</div>
													</div>
											</div>
												
											
												<div style="margin-left: 500px;" class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme" type="submit">Save</button>
													<button class="btn btn-theme04" type="button">Cancel</button>
												</div>
											</form>
										</div>

										<!-- /tab-content -->
									</div>
									<!-- /panel-body -->
								</div>
								<!-- /col-lg-12 -->
							</div>
							<!-- /row -->
						</div>
					</div>

				</div>

			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<%@ include file="/templates/admin/inc/footer.jsp"%>
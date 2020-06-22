
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
										<div class="col-lg-8 col-lg-offset-2 detailed">
											<h4 class="mb">Personal Information</h4>
											<form role="form" class="cmxform form-horizontal style-form">
												
												<div class="form-group">
													<label class="col-lg-2 control-label">Pay Rate ID</label>
													<div class="col-lg-6">
														<input type="text" name="pid" placeholder=" " id="pay_ray_id"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Pay Rate Name</label>
													<div class="col-lg-6">
														<input type="text" name="pname" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Value</label>
													<div class="col-lg-6">
														<input type="text" name="value" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Tax Parcentage</label>
													<div class="col-lg-6">
														<input type="text" name="tax" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Pay Type</label>
													<div class="col-lg-6">
														<input type="text" name="ptype" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Pay Amount</label>
													<div class="col-lg-6">
														<input type="text" name="pamount" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
													<div class="form-group">
													<label class="col-lg-2 control-label">Pay Rate ID</label>
													<div class="col-lg-6">
														<input type="text" placeholder=" " id="c-name"
															class="form-control" required="">
													</div>
												</div>
												
												<div class="col-lg-offset-2 col-lg-10">
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
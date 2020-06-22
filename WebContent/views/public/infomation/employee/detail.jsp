
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Benefit_Plan"%>
<%@page import="model.Job_History"%>
<%@page import="model.Personal"%>
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
			<%
				Personal personal = null;
			
			int typeofWork=0;
				if(request.getAttribute("personal")!=null){
					personal =(Personal)request.getAttribute("personal");
				}
				Payrate payrate = null;
				if(request.getAttribute("payrate")!=null){
					payrate = (Payrate)request.getAttribute("payrate");
				}
				Benefit_Plan benefit_Plan = null;
				
				if(request.getAttribute("benefit_Plan")!=null){
					benefit_Plan = (Benefit_Plan)request.getAttribute("benefit_Plan");
				}
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");	
					
			%>
        <div class="row mt">
          <div class="col-lg-12">
            <div class="row content-panel">
              <div class="col-md-4 profile-text mt mb centered">
                <div class="right-divider hidden-sm hidden-xs">
                  <h4><%=personal.getEmployee_Working().getHIRE_DATE_FOR_WORKING() %></h4>
                  <h6>Start working</h6>
                  <!-- <h4>290</h4>
                  <h6>FOLLOWING</h6> -->
                  <h4>$ <%=payrate.getPay_Amount() %></h4>
                  <h6>MONTHLY EARNINGS</h6>
                </div>
              </div>
              <!-- /col-md-4 -->
              <div class="col-md-4 profile-text">
                <h3><%=personal.getCURRENT_FIRST_NAME()+" "+personal.getCURRENT_MIDDLE_NAME()+ " " + personal.getCURRENT_LAST_NAME()%></h3>
                
                <!-- <h6>Main Administrator</h6> -->
                <p>Gender: <%=personal.getCURRENT_GENDER() %></p>
                <p>Date of Birth: <%=formatter.format(personal.getBIRTH_DATE()) %></p>
                <p>Adress: <%=personal.getCURRENT_ADDRESS_1()+", "+personal.getCURRENT_CITY()%></p>
                <p>Phone: <%=personal.getCURRENT_PHONE_NUMBER() %></p>
                <p>Email: <%=personal.getCURRENT_PERSONAL_EMAIL() %></p>
                <p></p>
                <br>
                <p><button class="btn btn-theme"><i class="fa fa-envelope"></i> Send Message</button></p>
              </div>
              <!-- /col-md-4 -->
              <div class="col-md-4 centered">
                <div class="profile-pic">
                  <p><img src="<%=request.getContextPath() %>/templates/admin/img/person.png" class="img-circle"></p>
                <!--   <p>
                    <button class="btn btn-theme"><i class="fa fa-check"></i> Follow</button>
                    <button class="btn btn-theme02">Add</button>
                  </p> -->
                </div>
              </div>
              <!-- /col-md-4 -->
            </div>
            <!-- /row -->
          </div>
          <!-- /col-lg-12 -->
          <div class="col-lg-12 mt">
            <div class="row content-panel">
              <div class="panel-heading">
                <ul class="nav nav-tabs nav-justified">
                  <li class="active">
                    <a data-toggle="tab" href="#overview" aria-expanded="false">Employee Working</a>
                  </li>
                  <li class="">
                    <a data-toggle="tab" href="#contact" class="contact-map" aria-expanded="false">Pay Rate</a>
                  </li>
                  <li class="">
                    <a data-toggle="tab" href="#edit" aria-expanded="true">Job History</a>
                  </li>
                   <li class="">
                    <a data-toggle="tab" href="#benefit" aria-expanded="true">Benefit Plan</a>
                  </li>
                </ul>
              </div>
              <!-- /panel-heading -->
              <div class="panel-body">
                <div class="tab-content">
                  <div id="overview" class="tab-pane">
                    <div class="row">
                       <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h4 class="mb">Personal Information</h4>
                        <form role="form" class="form-horizontal">
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Hire Date For Working:</label>
                            <div class="col-lg-6">
                              <input  type="text" value="<%=personal.getEmployee_Working().getHIRE_DATE_FOR_WORKING() %>" placeholder=" " id="c-name" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Working Comp Code</label>
                            <div class="col-lg-6">
                              <input  type="text" value="<%=personal.getEmployee_Working().getWORKERS_COMP_CODE() %>" placeholder=" " id="lives-in" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Termination Date</label>
                            <div class="col-lg-6">
                              <input  type="text" value="<%=personal.getEmployee_Working().getTERMINATION_DATE() %>" placeholder=" " id="country" class="form-control col-lg-12">
                            </div>
                          </div>
                          
                            <div class="form-group">
                            <label class="col-lg-2 control-label">Number Days Requirement Of Working Per Month:</label>
                            <div class="col-lg-6">
                              <input  type="text" value="<%=personal.getEmployee_Working().getNUMBER_DAYS_REQUIREMENT_OF_WORKING_PER_MONTH() %>" placeholder=" " id="country" class="form-control col-lg-12">
                            </div>
                          </div>
                          
                            <div class="form-group">
                            <label class="col-lg-2 control-label">Number Days Actual Of Working Per Month</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=personal.getEmployee_Working().getNUMBER_DAYS_ACTUAL_OF_WORKING_PER_MONTH() %>" id="country" class="form-control col-lg-12">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Total Number Vacation Working Days Per Month</label>
                            <div class="col-lg-6">
                              <input  type="text" value="<%=personal.getEmployee_Working().getTOTAL_NUMBER_VACATION_WORKING_DAYS_PER_MONTH() %>" placeholder=" " id="country" class="form-control col-lg-12">
                            </div>
                          </div>
                          
                        </form>
                      </div>
                      </div>
                    <!-- /OVERVIEW -->
                  </div>
                  <!-- /tab-pane -->
                  <div id="contact" class="tab-pane">
                    <div class="row">
                      
                      <!-- /col-md-6 -->
                    
                       <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h4 class="mb">PAY RATE</h4>
                        <form role="form" class="form-horizontal">
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Pay Rate Name:</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=payrate.getPay_Rate_Name() %>" id="addr1" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Value</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=payrate.getValue() %>" id="addr2" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Tax Percentage</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=payrate.getTax_Percentage() %>" id="phone" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Pay Type</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=payrate.getPay_Type() %>" id="cell" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Pay Amount</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " value="<%=payrate.getPay_Amount() %>" id="email" class="form-control col-lg-12">
                            </div>
                          </div>
                          
                        
                        </form>
                      </div>
                      <!-- /col-md-6 -->
             
                    <!-- /row -->
                  </div>
                  </div>
                  
                  <div id="benefit" class="tab-pane">
                    <div class="row">
                      
                      <!-- /col-md-6 -->
                    
                       <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h4 class="mb"><%=benefit_Plan.getPlan_Name() %></h4>
                        <form role="form" class="form-horizontal">
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Plan Name:</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" "  value="<%=benefit_Plan.getPlan_Name()%>" id="addr1" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Deductable</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" "  value="<%=benefit_Plan.getDeductable()%>" id="addr2" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Percentage Copay</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" "  value="<%=benefit_Plan.getPercentage_Copay() %>" id="phone" class="form-control col-lg-12">
                            </div>
                          </div>
                         
                        </form>
                      </div>
                      <!-- /col-md-6 -->
             
                    <!-- /row -->
                  </div>
                  </div>
                  <!-- /tab-pane -->
                  <div id="edit" class="tab-pane active">
                    <div class="row">
                    <%
                    	if(request.getAttribute("job_HistorieList")!=null){
                    		List<Job_History> job_HistorieList = (List<Job_History>)request.getAttribute("job_HistorieList");
                    		if(job_HistorieList.size()>0){
                    			for(Job_History jHistory:job_HistorieList){
                    				
                    		
                    %>
                      <div class="col-lg-8 col-lg-offset-2 detailed mt">
                        <h4 class="mb"><%=jHistory.getDIVISION() %></h4>
                        <form role="form" class="form-horizontal">
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Department:</label>
                            <div class="col-lg-6">
                              <input name="department"  type="text" placeholder=" " value="<%=jHistory.getDEPARTMENT() %>" id="addr1" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">From date:</label>
                            <div class="col-lg-6">
                              <input name="fromdate" type="text" placeholder=" " value="<%=jHistory.getFROM_DATE() %>" id="addr2" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Thru date:</label>
                            <div class="col-lg-6">
                              <input name="thruday" type="text" placeholder=" " value="<%=jHistory.getTHRU_DATE() %>" id="phone" class="form-control col-lg-12">
                            </div>
                          </div>
                         <div class="form-group">
                            <label class="col-lg-2 control-label">Job Title:</label>
                            <div class="col-lg-10">
                              <textarea  rows="10" cols="30" class="form-control col-lg-12" id="" name="title"><%=jHistory.getJOB_TITLE() %></textarea>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Subpervisor:</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " name="subpervisor" value="<%=jHistory.getSUPERVISOR() %>" id="email" class="form-control col-lg-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Type of Work:</label>
                            <div class="col-lg-6">
                              <input  type="text" placeholder=" " name="type"  value="<%=jHistory.getTYPE_OF_WORK() %>" id="skype" class="form-control col-lg-12">
                            </div>
                          </div>
                       <!-- <div style="margin-left: 120px;" class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme" type="submit">Save</button>
													<button class="btn btn-theme04" type="button">Cancel</button>
							</div> -->
                        </form>
                      </div>
                      <%
                    			}
                    		}
                    	}
                      %>
                      <!-- /col-lg-8 -->
                    </div>
                    <!-- /row -->
                  </div>
                  <!-- /tab-pane -->
                </div>
                <!-- /tab-content -->
              </div>
              <!-- /panel-body -->
            </div>
            <!-- /col-lg-12 -->
          </div>
          <!-- /row -->
        </div>
        <!-- /container -->
      </section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<%@ include file="/templates/admin/inc/footer.jsp"%>
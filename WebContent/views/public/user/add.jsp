<%@page import="model.Role"%>
<%@page import="utils.DefineUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Employee"%>
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
				<div class="form-panel">
              <div class=" form">
              <h4 class="mb">Add User</h4>
              <%
              	String username="";
              	String fullname="";
              	String email="";
              	int role_id=0;
              	if(request.getAttribute("userTrung")!=null){
              		User userTrung = (User) request.getAttribute("userTrung");
              		username = userTrung.getUsername();
              		fullname = userTrung.getFullname();
              		email = userTrung.getEmail();
              		role_id = userTrung.getRole().getRole_id();
              
              
              %>
              <div class="alert alert-danger" role="alert">
				  User name "<%=userTrung.getUsername()%>" already exist!
				</div>
              <%
            	}
              %>
                <form class="cmxform form-horizontal style-form" id="commentForm" method="post" action="<%=request.getContextPath()%>/user/add">
                  <div class="form-group ">
                    <label for="cname" class="control-label col-lg-2">Username (required)</label>
                    <div class="col-lg-10">
                      <input class=" form-control" value="<%=username %>" id="cname" name="username" minlength="3" type="text" required="">
                    </div>
                  </div>
                   <div class="form-group ">
                    <label for="cname" class="control-label col-lg-2">Fullname (required)</label>
                    <div class="col-lg-10">
                      <input class=" form-control" value="<%=fullname %>" id="cname" name="fullname" minlength="3" type="text" required="">
                    </div>
                  </div>
                  <div class="form-group ">
                    <label for="cemail" class="control-label col-lg-2">E-Mail (required)</label>
                    <div class="col-lg-10">
                      <input class="form-control " value="<%=email %>" id="cemail" type="email" name="email" required="">
                    </div>
                  </div>
                   <div class="form-group ">
                    <label for="cname" class="control-label col-lg-2">Role (required)</label>
                    <div class="col-lg-10">
                     <select name="role" class="form-control " required>
                     <option  value="">Select role</option>
                     	<%
                     		if(request.getAttribute("roleList")!=null){
                     			List<Role> roleList = (List<Role>)request.getAttribute("roleList");
                     			if(roleList.size()>0){
                     				for(Role role:roleList){
                     			
                     	%>
                     	<option  value="<%=role.getRole_id()%>"><%=role.getRole_name() %></option>
                     	<%
                		
                     				}
                     			}
                     		}
                     	%>
                     </select>
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                      <button class="btn btn-theme" type="submit">Save</button>
                      <button class="btn btn-theme04" type="button">Cancel</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
			</section>
			<!-- /wrapper -->
		</section>
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<script>
			document.getElementById("alert").classList.add('active');
			document.getElementById("home").classList.remove("active");
		</script>
		mây
		<%@ include file="/templates/admin/inc/footer.jsp"%>
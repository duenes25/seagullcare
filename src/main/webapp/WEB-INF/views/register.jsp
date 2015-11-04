<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<html lang="en">
<head>


<jsp:include page="head.jsp" />

</head>

<body style="padding-top: 72px;">

	<div class="container">

		<div class="navbar-wrapper">
			<div class="container">

				<nav class="navbar navbar-default navbar-static-top">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="welcome">Seagull Care</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="welcome">Home</a></li>
								<li><a href="welcome#about">About</a></li>
								<li><a href="contact">Contact</a></li>
								<li class="active"><a href="register">Register</a></li>
								<li><a href="login">Log In</a></li>
							</ul>
						</div>
					</div>
				</nav>

			</div>
		</div>



		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">





			<h1 class="text-center">
				<small>Register for Seagull Care</small>
			</h1>
			
			<%@ include file="notificationSection.jsp" %>
			
			<p
				class="col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">Register
				as a</p>
			<!-- Tabs -->
			<ul id="myTab"
				class="nav nav-tabs col-xs-offset-1 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
				<li class="active"><a href="#company" data-toggle="tab">Company</a></li>
				<li><a href="#member" data-toggle="tab">Member</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="company">
					<!-- Show the Company Form -->
					<div class="row">
						<div
							class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1"
							style='background-color: white; border-radius: 10px;'>
							<div style="margin-top: 20px"></div>
							
							<form:form id="companyForm" method="POST" modelAttribute="newCompany" class="form-horizontal" role="form">
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="companyName">*Company
										Name:</form:label>
									<div class="col-sm-10">
										<form:input type="text" path="companyName" class="form-control" id="name"
											placeholder="Enter name" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="companyPhone">*Company
										Phone:</form:label>
									<div class="col-sm-10">
										<form:input type="tel" class="form-control" path="companyPhone"
											placeholder="Enter phone number" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="companyAddress">*Company
										Address:</form:label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="companyAddress"
											placeholder="Enter Address" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="pointOfContactName">*Point
										of contact name:</form:label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="pointOfContactName"
											placeholder="Enter name"  required="required"/>
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="pointOfContactEmail">*Point
										of contact email:</form:label>
									<div class="col-sm-10">
										<form:input type="email" class="form-control" path="pointOfContactEmail"
											placeholder="Enter email" required="required" />
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="pointOfContactPhone">*Point
										of contact phone</form:label>
									<div class="col-sm-10">
										<form:input type="tel" class="form-control" path="pointOfContactPhone"
											placeholder="Enter phone number" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-info">Submit</button>
									</div>
								</div>
							</form:form>

						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="member">

					<!-- Member Form -->
					<div class="row">
						<div
							class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1"
							style='background-color: white; border-radius: 10px;'>
							<div style="margin-top: 20px"></div>

							<form:form id="memberForm" method="POST" modelAttribute="newMember" class="form-horizontal" role="form">
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="memberName">*Name:</form:label>
									<div class="col-sm-10">
										<form:input type="text" class="form-control" path="memberName"
											placeholder="Enter name" required="required" autofocus="true" />
									</div>
								</div>

								<div class="form-group">
									<form:label class="control-label col-sm-2" path="memberPhone">*Phone:</form:label>
									<div class="col-sm-10">
										<form:input type="tel" class="form-control" path="memberPhone"
											placeholder="Enter phone number" required="required"/>
									</div>
								</div>
								<div class="form-group">
									<form:label class="control-label col-sm-2" path="memberEmail">*Email:</form:label>
									<div class="col-sm-10">
										<form:input type="email" class="form-control" path="memberEmail"
											placeholder="Enter email" required="required" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-info">Submit</button>
									</div>
								</div>
							</form:form>
							

						</div>
					</div>
				</div>
			</div>
















			<div class="text-center">or</div>
			<p class="text-center">Contact via phone : (626) 422-1121</p>


		</div>

	</div>
	<!-- /container -->


	<jsp:include page="footer.jsp" />

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
							<a class="navbar-brand" href="welcome">Express Care</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="welcome">Home</a></li>
								<li><a href="welcome#about">About</a></li>
								<li><a href="contact">Contact</a></li>
								<li><a href="register">Register</a></li>
								<li class="active"><a href="login">Log In</a></li>
							</ul>
						</div>
					</div>
				</nav>

			</div>
		</div>



		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">

			<h1 class="text-center">
				<small>Sign In</small>
			</h1>
			<p class="text-center">
				Sign In to Express Care or <a href="register">Register</a> for a new
				account.
			</p>

			<div class="row">

				<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4"
					style='background-color: white; border-radius: 10px;'>
					<div style="margin-top: 20px"></div>
					<form role="form" name="loginForm" action="j_spring_security_check"
						method='POST'>
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail"
									name="inputEmail" type="email" required autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									name="inputPassword" type="password" value="" required>
							</div>
							<!-- <div class="checkbox">
								<label> <input name="remember" type="checkbox"
									value="Remember Me">Remember Me
								</label>
							</div> -->

							<!-- Change this to a button or input when using this as a form -->

							<button type="submit" class="btn btn-primary btn-lg btn-block">Log
								In</button>

						</fieldset>
					</form>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />



</body>
</html>

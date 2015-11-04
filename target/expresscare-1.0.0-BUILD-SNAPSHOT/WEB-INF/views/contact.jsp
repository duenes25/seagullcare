<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
	<head>
    
    	 
		<jsp:include page="head.jsp"/>
		
		
  	</head>
	 
	<body style="padding-top: 72px;">

		<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-default navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="welcome">Express Care</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="welcome">Home</a></li>
                <li><a href="welcome#about">About</a></li>
                <li class="active"><a href="contact">Contact</a></li>
                <li><a href="register">Register</a></li>
                <li><a href="login">Log In</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>


    <div class="container">
		
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
      <p></p>
        <h1 class="text-center"  ><small>Contact Us</small></h1>
        
        <%@ include file="notificationSection.jsp" %>
        

        <p>Please fill out the following form</p>
        
        
		<form:form id="myForm" method="POST" modelAttribute="newContact" class="form-horizontal" role="form">
			<div class="form-group">
    			<form:label class="control-label col-sm-2" path="contactName" >Name:</form:label>
	    		<div class="col-sm-10">
	    			<form:input type="text" path="contactName" class="form-control" placeholder="Enter name"  required="required"/>
	    		</div>
  			</div>
  		
  			<div class="form-group">
  				<form:label class="control-label col-sm-2" path="contactEmail" >*Email:</form:label>
    			<div class="col-sm-10">
    				<form:input type="email" class="form-control" path="contactEmail" placeholder="Enter Email" required="required"/>
    			</div>
  			</div>
  
  			<div class="form-group">
  				<form:label class="control-label col-sm-2" path="contactPhone" >Phone:</form:label>
    			<div class="col-sm-10"> 
    				<form:input type="tel" class="form-control" path="contactPhone" placeholder="(xxx)xxx-xxxx" />
    			</div>
	  		</div>
  
  
  			<div class="form-group">
  				<form:label class="control-label col-sm-2" path="contactComments" >Comments:</form:label>
  				<div class="col-sm-10">
	  				<form:textarea class="form-control" rows="5" path="contactComments" placeholder="Enter comment"></form:textarea>
				</div>
			</div>
  
  
  			<div class="form-group"> 
    			<div class="col-sm-offset-2 col-sm-10">
	      			<button type="submit" id="submit-form" class="btn btn-info">Submit</button>
    			</div>
	  		</div>
		</form:form>
		
			<div class="text-center">or</div> 
		<p class="text-center">Contact via phone : (626) 422-1121</p>


      </div>

    </div> <!-- /container -->

	<jsp:include page="footer.jsp"/>

    
  </body>
</html>

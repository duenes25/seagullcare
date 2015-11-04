<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
<head>

    <jsp:include page="head.jsp"/>
    

</head>

<body>

    <div id="wrapper">

        <jsp:include page="memberNav.jsp"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">My Settings</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8 col-md-8">
                
	                <div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">Registered Attendants</div>
							<div class="table-responsive">
							<!-- Table -->
							<table class="table table-striped">
	
	
				    			<thead>
							      <tr>
							        <th>Name</th>
							      </tr>
							    </thead>
			    				<tbody>
						    		<tr>
						        		<td>Emely Duenes</td>
						        		<td>
						        			<a class="btn btn-med btn-danger" href="#" role="button">
				     						<span class="glyphicon glyphicon-remove"></span>
				     						</a>
				     						<a class="btn btn-med btn-warning" href="#" role="button">
				     						<span class="fa fa-pencil-square-o"></span>
				     						</a>
				     					</td>
						      		</tr>
					    			<tr>
						        		<td>Mia Duenes</td>
						        		<td>
						        			<a class="btn btn-med btn-danger" href="#" role="button">
				     						<span class="glyphicon glyphicon-remove"></span>
				     						</a>
				     						<a class="btn btn-med btn-warning" href="#" role="button">
				     						<span class="fa fa-pencil-square-o"></span>
				     						</a>
				     					</td>
						      		</tr>
			    					
			      
			    				</tbody>
			  
	
	
							</table>
							</div>
					</div>
                    
                </div>
                
			</div>
            
            
            <div class="row">
                <div class="col-lg-8 col-md-8">
                
	                <div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">Register New Attendant</div>
							
						<div class="panel-body">	
							<!-- <div class="col-lg-6"> -->
							
						
							<label class="control-label col-sm-3" >Select Location:</label>
							<div class="col-sm-9">
								<select class="selectpicker" data-width="100%"  >
										<option value="test"></option>
            							<option value="test">Seagull School - Kapolei</option>
            							<option value="test">Seagull School - Ewa Beach</option>
            							<option value="test">Seagull School - Mililani</option>

            							
								</select>
	  						</div>
							<div style="margin-top: 50px;"></div>
							<label class="control-label col-sm-3" >Select Attendant:</label>
							<div class="col-sm-9">
								<select class="selectpicker" data-width="100%"  >
										<option value="test"></option>
            							<option value="test">Keone Mercado</option>
            							<option value="test">Brandon Iwai</option>
            							<option value="test">Joshua Yanez</option>            							
								</select>
	  						</div>
							
							<div style="margin-top: 100px;"></div>
							<label class="control-label col-sm-3" ></label>
							<div class="col-sm-4" style="text-align: right;">
								Attendant Birth Date:
								</div>
							<div class="col-sm-4 ">	
								<input type="date" class="form-control" >
	  						</div>
							
							
							
							<div style="margin-top: 150px;"></div>
							<label class="control-label col-sm-3" ></label>
   							<div class="col-sm-4" style="text-align: right;">
   							Last Four (SSN) xxx-xx-
   							</div>
   							<div class="col-sm-4">
   							<input type="text" class="form-control" >
							</div>
   							
   							<button type="button" class="btn btn-primary btn-md">
  								Send Reigstration Request
  							</button>
					    
  
  
  <!-- </div>/.col-lg-6 -->
            				
	  					</div>
					</div>
                    
                </div>
                
			</div>
             
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


	<jsp:include page="footer.jsp"/>
    

</body>
</html>

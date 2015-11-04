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
                    <h1 class="page-header">Drop Off / Pick Up Report</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-10 col-md-8">
                
	                <div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">From:      To:   </div>
							<div class="table-responsive">
							<!-- Table -->
							<table class="table table-striped">
	
	
				    			<thead>
							      <tr>
							        <th>Name</th>
							        <th>Action</th>
							        <th>Date</th>
							        <th>Responsible Party</th>
							      </tr>
							    </thead>
			    				<tbody>
						    		<tr>
						        		<td>Emely Duenes</td>
						        		<td>Dropped Off</td>
						        		<td>10/30/2015 8:30AM</td>
						        		<td>Eric Duenes</td>
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
						        		<td>Emely Duenes</td>
						        		<td>Picked Up</td>
						        		<td>10/30/2015 3:15PM</td>
						        		<td>Priscilla Duenes</td>
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
            
             
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


	<jsp:include page="footer.jsp"/>
    

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
<head>

    <jsp:include page="head.jsp"/>
    

</head>

<body>

    <div id="wrapper">

        <jsp:include page="companyNav.jsp"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Company Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	
                <div class="col-lg-7 col-md-8">
                    <div class="panel panel-primary">
                        <a href="#">
                        <div class="panel-heading" style="color:white; background:#0088CC" >
                        
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-sign-in fa-5x"></i>
                                    
                                </div>
                                
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>Drop Off's Pending</div>
                                </div>
                            </div>
                            
                        </div>
                        
                        
                            <!-- <div class="panel-footer">
                                <span class="pull-left">Drop Off</span>
                                <div class="clearfix"></div>
                            </div> -->
                        </a>
                    </div>
                </div>
			</div>
            <div class="row">
                <div class="col-lg-7 col-md-8">
                    <div class="panel panel-green">
                    <a href="#">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-sign-out fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">2</div>
                                    <div>Pick Up's Pending</div>
                                </div>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
             </div>
             
             <div class="row">
                <div class="col-lg-7 col-md-8">
                    <div class="panel panel-yellow">
                    <a href="#">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">10</div>
                                    <div>Registration Requests</div>
                                </div>
                            </div>
                        </div>
                        </a>
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

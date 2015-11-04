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
                    <h1 class="page-header">Member Dashboard</h1>
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
                                    
                                    <div class="row">
                                    	<div class="col-xs-12">
                                    		Drop Off
                                			<!--  <i class="fa fa-exclamation-triangle fa-2x" style="color:orange"></i>-->
                                		</div>
                                	</div>
                                </div>
                                
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Emely Duenes</div>
                                    <div>Picked Up 10/20/2015 12:01</div>
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
                                    <div class="row">
                                    	<div class="col-xs-12">
                                			Pick Up
                                		</div>
                                	</div>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">Mia Duenes</div>
                                    <div>Dropped Off 10/20/2015 12:01</div>
                                </div>
                            </div>
                        </div>
                        </a>
                        <a href="#">
                            <div class="panel-footer" style="color:orange">
                                <i class="fa fa-exclamation-triangle fa-2x" ></i>
                                Mia Had an Accident Today!
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
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

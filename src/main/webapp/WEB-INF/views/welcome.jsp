<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
<head>
     
     <jsp:include page="head.jsp"/>
     
  </head>
<!-- NAVBAR
================================================== -->
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
              <a class="navbar-brand" href="welcome">Seagull Care</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="welcome">Home</a></li>
                <li><a href="welcome#about">About</a></li>
                <li><a href="contact">Contact</a></li>
                <li><a href="register">Register</a></li>
                <li><a href="login">Log In</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <!-- <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide"> -->
          <div class="container">
            <div class="carousel-caption">
              <h1>Seagull Care</h1>
              <p>Facilitating automated tracking of children and adult daycare.  Registration is free and easy</p>
              <p><a class="btn btn-lg btn-primary" href="register" role="button">Sign up today</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Virtual Interaction with Caregivers</h1>
              <p>Seagull Care enables users to Check In and Check Out their child or adult using any mobile device.  Location awareness integrate your phone and watch with your caregiver as well.</p>
              <p><a class="btn btn-lg btn-primary" href="welcome#about" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Accuracy and Efficiency</h1>
              <p>In addition to streamlining your interaction with caregivers, Seagull Care provides real-time accurate reports and information to both the facility and its members .</p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing" id="about">


      <!-- START THE FEATURETTES -->

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Dropping Off <span class="text-muted">- Simple and Reliable.</span></h2>
          <p class="lead">Seagull Care provides an easy and reliable mechanism to safely drop off and check in your dependent from anywhere and ensure that he/she has been properly attended to.</p>
          <p class="pull-right"><a href="#"><i class="fa fa-chevron-up fa-fw"></i> Back to top</a></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Picking Up <span class="text-muted">- Safe and Secure</span></h2>
          <p class="lead">Picking up is made simple with Seagull Care.  Using Seagull Care you can interact with the caregiver to ensure release and acknowledge check out of your dependent.</p>
          <p class="pull-right"><a href="#"><i class="fa fa-chevron-up fa-fw"></i> Back to top</a></p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Reporting <span class="text-muted">- Clear and Concise</span></h2>
          <p class="lead">Seagull Care allows you to retrieve the data you need when you need it.  The reports allow you to track usage, retrieve historical records and lookup any actovoty that took place within the application.</p>
          <p class="pull-right"><a href="#"><i class="fa fa-chevron-up fa-fw"></i> Back to top</a></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">
      
      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Registration</h2>
          <p class="lead">Registration is free and easy.  Click on <a href="#registration">Registration</a> from the menu above to have you and your facility using Seagull Care immediately.</p>
          <p class="pull-right"><a href="#"><i class="fa fa-chevron-up fa-fw"></i> Back to top</a></p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      

      <!-- /END THE FEATURETTES -->


      <!-- FOOTER -->
      <footer>
        <p>© 2015 Head High, Inc.</p>
      </footer>

    </div><!-- /.container -->

	<jsp:include page="footer.jsp"/>
  

</body></html>

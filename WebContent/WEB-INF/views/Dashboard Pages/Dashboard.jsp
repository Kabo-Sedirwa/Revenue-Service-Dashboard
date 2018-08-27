<!DOCTYPE>
<html>
 <title>Dashboard</title>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="../assets/taxService.css">
 

 <body class="w3-theme-l3">

 <!-- Top container -->
 <div class="w3-bar w3-top w3-theme-d5 w3-large" style="z-index:4">
   <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open()"><i class="fa fa-bars"></i>  Menu</button>
   <span class="w3-bar-item w3-right"><a href="" onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();"style="text-decoration:none;" ><i class="fa fa-sign-out"></i> Logout</a></span>
   
   
   <form id="logout-form" action="${pageContext.request.contextPath}/Logout" method="post" style="display: none;">
                                        </form>
 </div>

 <!-- Sidebar/menu -->
 <nav class="w3-sidebar w3-collapse w3-theme-l1 w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
   <div class="w3-container w3-row">
     <div class="w3-col s4">
       <img src="./assets/images/user.png" class="w3-circle w3-margin-right" style="width:46px">
     </div>
     <div class="w3-col s8 w3-bar">
       <span>Welcome, <strong>${user.firstName} ${user.lastName}</strong></span><br>
       <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a>
       <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
       <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
     </div>
   </div>
   <hr>
   <div class="w3-container">
     <h4>Dashboard</h4>
   </div>
   <div class="w3-bar-block">
     <button  class="w3-bar-item  w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</button>
     <button  class="w3-bar-item  menulink w3-button w3-padding w3-theme-d2" onclick="openMenu(event,'Overview')"><i class="fa fa-globe"></i>  Overview</button>
     <button  class="w3-bar-item  menulink w3-button w3-padding" onclick="openMenu(event,'taxMenu')"><i class="fa fa-tasks"></i> Add Taxable</button>
   </div>
 </nav>


 <!-- Overlay effect when opening sidebar on small screens -->
 <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

 <!-- !PAGE CONTENT! -->
 <div class="w3-main" style="margin-left:300px;margin-top:43px;">

   <!-- Header -->
   <header class="w3-container w3-theme-d3" style="padding-top:22px">
     <h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>
   </header>
 <br>
  <div id ="Overview" class="menu">
 
	<jsp:include page="../Dashboard Pages/overview.jsp" flush="true" />
  </div>

  <div id="taxMenu" class="menu" style="display:none" >

	<jsp:include page="../Dashboard Pages/taxmenuModals.jsp" flush="true" />
  </div>



   <!-- End page content -->
  </div>	

 <script>
 // Get the Sidebar
 var mySidebar = document.getElementById("mySidebar");

 // Get the DIV with overlay effect
 var overlayBg = document.getElementById("myOverlay");

 // Toggle between showing and hiding the sidebar, and add overlay effect
 function w3_open() {
     if (mySidebar.style.display === 'block') {
         mySidebar.style.display = 'none';
         overlayBg.style.display = "none";
     } else {	
         mySidebar.style.display = 'block';
         overlayBg.style.display = "block";
     }
 }

 // Close the sidebar with the close button
 function w3_close() {
     mySidebar.style.display = "none";
     overlayBg.style.display = "none";
 }


 </script>


<!-- Sidebar navigation js script --> 
   
   <script>
function openMenu(evt, menuName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("menu");
  for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("menulink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-theme-d2", "");
  }
  document.getElementById(menuName).style.display = "block";
  evt.currentTarget.className += " w3-theme-d2";
}
</script>
<!-- End of Sidebar navigation js script --> 

 </body>

</html>

​

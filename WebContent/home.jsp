<!DOCTYPE>
<html>
 <title>Home</title>
 <meta charset="utf-8">
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="assets/taxService.css">


 <body class="w3-theme-d1 ">
   <div class="w3-container">

     <div class="w3-display-container">


      <div class="w3-row">
  <div class="w3-col s5 w3-center" id="loginPanel" >

    <div class="w3-card w3-center w3-theme-d5" >
      <div class="w3-container " style="padding:0;">
        <div class="w3-row">
      <button class="w3-button w3-block tablink w3-amber w3-half" onclick="openForm(event,'Login')">Login</button>
      <button class="w3-button w3-block tablink w3-half" onclick="openForm(event,'SignUp')">Sign Up</button>
        </div>
  </div>
  
  <div id="errorDiv" class="w3-panel w3-red">
  <h3>${errorString} </h3>
  </div>

  <br>
  <!-- Login Page  -->
  
  <div id="Login" class="w3-container form w3-padding-16">
    <form action = "${pageContext.request.contextPath}/Login"  class="w3-container" method="post">
      <label class="w3-text-white w3-left"><b>Email</b></label>
      <input name ="email"class="w3-input w3-border w3-light-grey" type="text" required>
      <br>

      <label class="w3-text-white w3-left"><b>Password</b></label>
      <input name="password" class="w3-input w3-border w3-light-grey" type="password" required>
      <br>
      <button class="w3-button w3-block w3-amber w3-padding-16" style="width:30%;margin-left:35%;">Login</button>
    </form>
</div>
<!-- Sign Up Page  -->
<div id="SignUp" class="w3-container form w3-padding-16" style="display:none">
  <form action="${pageContext.request.contextPath}/Register" class="w3-container" method="post">
    <label class="w3-text-white w3-left"><b>First Name</b></label>
    <input name="firstName" class="w3-input w3-border w3-light-grey" type="text" required>
    <br>

    <label class="w3-text-white w3-left"><b>Last Name</b></label>
    <input name="lastName" class="w3-input w3-border w3-light-grey" type="text" required>
    <br>

    <label class="w3-text-white w3-left"><b>Email</b></label>
    <input name="email" class="w3-input w3-border w3-light-grey" type="text" required>
    <br>

    <label class="w3-text-white w3-left"><b>Password</b></label>
    <input name="password" class="w3-input w3-border w3-light-grey" type="password" required>
    <br>

    <button class="w3-button w3-block w3-amber w3-padding-16" style="width:30%;margin-left:35%;" type="submit">Sign Up</button>
  </form>
</div>
 </div>

 </div>

 </div>
     </div>
   </div>

<script>

var errorDiv = document.getElementById("errorDiv");

var error = "${errorString}";


if(error == ""){ errorDiv.style.display="none"}

else{ errorDiv.style.display="block" };

</script>

   <script>
   function openForm(evt, formName) {
     var i, x, tablinks;
     x = document.getElementsByClassName("form");
     for (i = 0; i < x.length; i++) {
         x[i].style.display = "none";
     }
     tablinks = document.getElementsByClassName("tablink");
     for (i = 0; i < x.length; i++) {
         tablinks[i].className = tablinks[i].className.replace(" w3-amber", "");
     }
     document.getElementById(formName).style.display = "block";
     evt.currentTarget.className += " w3-amber";
   }
   </script>
 </body>

</html>

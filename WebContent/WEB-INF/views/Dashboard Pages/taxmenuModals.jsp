 <div class="w3-row-padding">
  <div class="w3-col s4 w3-center w3-animate-top">
    <div class="w3-card-4" style="width:100%">
    <img src="./assets/images/pic1.jpg" alt="Person" style="width:100%">
       <div class="w3-container w3-theme-l4" style="padding:0;">
        
 		<button class="w3-button w3-theme-d1 w3-padding-16 hvr-fade" style="width:100%;" 
 			onclick="document.getElementById('incomeTaxModal').style.display='block'">Enter income Tax Application Form</button>
     </div>
   </div>
  </div>



  <div class="w3-col s4 w3-center w3-animate-bottom"> 
   <div class="w3-card-4" style="width:100%">
    <img src="./assets/images/pic2.jpg" alt="Person" style="width:100%">
      <div class="w3-container w3-theme-l4" style="padding:0;">
        
 		<button class="w3-button w3-theme-d1 w3-padding-16 hvr-fade" style="width:100%;"
 		 onclick="document.getElementById('companyTaxModal').style.display='block'">Company Tax Application Form</button>
     </div>
   </div>
  </div>
 </div> 

<!-- income tax modal -->


  <div id="incomeTaxModal" class="w3-modal ">
    <div class="w3-modal-content w3-card-4 w3-animate-top">
      <header class="w3-container w3-blue"> 
        <span onclick="document.getElementById('incomeTaxModal').style.display='none'" 
        class="w3-button w3-display-topright">&times;</span>
        <h2>Income Tax</h2>
      </header>
      <div class="w3-container">
        <div id="errorDiv" class="w3-panel w3-red">
  <h3>${errorString} </h3>
  </div>
      <br>
      <form action="${pageContext.request.contextPath}/incomeTaxServlet" method="post">
  <div class="w3-row-padding">
   <div class="w3-half">
     <h4>First Name</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter first name" name="firstName" required>
   </div>
  <div class="w3-half">
   <h4>Last Name</h4>
    <input class="w3-input w3-border" type="text" placeholder="Please enter last name" name="lastName" required>
  </div>
  <div class="w3-half">
     <h4>Postal Address</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter First Name" name="postalAddress" required>
  </div>
   <div class="w3-half">
     <h4>Residential Address</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter Residential " name="residentialAddress" required>
  </div>
   <div class="w3-half">
     <h4>Occupation Industry</h4>
     <select class="w3-select" name="industry" required>
       <option value="" disabled selected>Choose your industry</option>
       <option value="Information Technology">Information Technology</option>
       <option value="Civil Service">Civil Service</option>
       <option value="Financial">Financial</option>
       <option value="Private Sector">Private Sector</option>
       <option value="Tourism">Tourism</option>
      </select> 
   </div>
   <div class="w3-half">
     <h4>Date Of Birth</h4>
      <input class="w3-input w3-border" type="date" placeholder="Please select date of birth " name="dob" required>
  </div>
     <div class="w3-half">
     <h4>Salary</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter your yearly salary " name="salary" required>
  </div>


 		

    </div> 
   	<br>
 		<button class="w3-button w3-theme-d1 w3-padding-16 hvr-fade" style="width:100%;">Submit</button>
 		
 		</form>
       </div>
        	<br>
        	  <footer class="w3-container w3-blue">
         <p>2018</p>
       </footer>
       </div>
   </div>
        	<!-- End of income tax modal -->
        	
        	<!-- Company tax modal -->
        	
        	<div id="companyTaxModal" class="w3-modal ">
    <div class="w3-modal-content w3-card-4 w3-animate-top">
      <header class="w3-container w3-blue"> 
        <span onclick="document.getElementById('companyTaxModal').style.display='none'" 
        class="w3-button w3-display-topright">&times;</span>
        <h2>Company Tax</h2>
      </header>
      <div class="w3-container">
      <br>
      <form action="${pageContext.request.contextPath}/CompanyTaxServlet" method="post">
  <div class="w3-row-padding">
   <div class="w3-half">
     <h4>Company Name</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter company name" name="companyName" required>
   </div>
  <div class="w3-half">
   <h4>Company Reg No.</h4>
    <input class="w3-input w3-border" type="text" placeholder="Please enter Company Registration Number" name="companyRegNo" required>
  </div>
  <div class="w3-half">
     <h4>Postal Address</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter postal address" name="postalAddress" required>
  </div>
   <div class="w3-half">
     <h4>Vat Number</h4>
      <input class="w3-input w3-border" type="text" placeholder="Please enter Vat NUmber " name="vatNumber" required>
  </div>
   <div class="w3-half">
     <h4>Occupation</h4>
     <select class="w3-select" name="industry" required>
     <option value="" disabled selected>Choose your industry</option>
       <option value="Information Technology">Information Technology</option>
       <option value="Civil Service">Civil Service</option>
       <option value="Financial">Financial</option>
       <option value="Private Sector">Private Sector</option>
       <option value="Tourism">Tourism</option>
      </select> 
   </div>
   <div class="w3-half">
     <h4>Number of Directors</h4>
    <select class="w3-select" name="directors" required>
       <option value="" disabled selected>Number Of Directors</option>
       <option value="1">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
      </select> 
   </div>

   </div> 
   	<br>
   	
 		<button class="w3-button w3-theme-d1 w3-padding-16 hvr-fade" type="submit" style="width:100%;">Submit</button>
 	</form>	
       </div>
          	<br>
               	<!--End Company tax modal -->
       
       <footer class="w3-container w3-blue">
         <p>2018</p>
       </footer>
     </div>
   </div>


<script>

var errorDiv = document.getElementById("errorDiv");

var error = "${errorString}";


if(error == ""){ errorDiv.style.display="none"}

else{ errorDiv.style.display="block" };

</script>



 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="w3-row-padding w3-margin-bottom">

     <div class="w3-third">
       <div class="w3-container w3-theme-d2 w3-padding-16 w3-animate-top">
         <div class="w3-left"><i class="fa fa-child w3-xxxlarge"></i></div>
         <div class="w3-right">
           <h3>${taxPayerTotal}</h3>
         </div>
         <div class="w3-clear"></div>
         <h4>Number of Tax Payers</h4>
       </div>
     </div>
     <div class="w3-third">
       <div class="w3-container w3-theme-d2 w3-padding-16 w3-animate-bottom">
         <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
         <div class="w3-right">
           <h3>${directorCount}</h3>
         </div>
         <div class="w3-clear"></div>
         <h4>Number of Company Directors</h4>
       </div>
     </div>
     <div class="w3-third">
       <div class="w3-container w3-theme-d2 w3-text-white w3-padding-16 w3-animate-top">
         <div class="w3-left"><i class="fa fa-briefcase w3-xxxlarge"></i></div>
         <div class="w3-right">
           <h3>${companyCount}</h3>
         </div>
         <div class="w3-clear"></div>
         <h4>Number Of Companies</h4>
       </div>
     </div>
   </div>
   <hr>

   <div class="w3-panel w3-animate-bottom">
     <div class="w3-row-padding" style="margin:0 -16px">
        <div class="w3-row">
    <button class="w3-bar-item w3-button w3-half w3-border w3-border-blue tablink w3-theme-d1" onclick="openRecords(event,'companyRecords')">Company Records</button>
    <button class="w3-bar-item w3-button w3-half w3-border w3-border-blue tablink" onclick="openRecords(event,'incomeTaxRecords')">Income Tax Records</button>
  </div>
  	<br>
  
  <div id="companyRecords" class="w3-container w3-border records">
  <table class="w3-table-all w3-hoverable">
   <thead class="w3-blue">
      <tr class="w3-light-grey">
        <th>Company Name</th>
        <th>Company Registration No. </th>
        <th>Postal Address</th>
        <th>VAT Number</th>
        <th>Industry</th>
        <th>No Of Directors</th>
        
      </tr>
    </thead>
     <c:forEach items="${companyRecords}" var="companyRecords">
    <tr>
      <td>${companyRecords.companyName}</td>
      <td>${companyRecords.companyRegNo}</td>
      <td>${companyRecords.postalAddress}</td>
      <td>${companyRecords.vatNumber}</td>
      <td>${companyRecords.industry}</td>
      <td>${companyRecords.numberOfDirectors}</td>
      
    </tr>
     </c:forEach>
  </table>
  </div>
	<br>
	
  <div id="incomeTaxRecords" class="w3-container w3-border records" style="display:none">
    <table class="w3-table-all  w3-hoverable">
    <thead>
      <tr class="w3-light-grey">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Postal Address</th>
        <th>Residential Address</th>
        <th>Industry</th>
        <th>Date Of Birth</th>
        
        
      </tr>
    </thead>
     <c:forEach items="${incomeTaxRecords}" var="incomeReords">
    <tr>
      <td>${incomeReords.firstName}</td>
      <td>${incomeReords.lastName}</td>
      <td>${incomeReords.postalAddress}</td>
      <td>${incomeReords.residentialAddress}</td>
      <td>${incomeReords.industry}</td>
      <td>${incomeReords.DOB}</td>
    </tr>
     </c:forEach>

  </table>
  </div>

  </div>
     </div>
   <hr>
   
 

<script>
function openRecords(evt, cityName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("records");
  for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" w3-theme-d1", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " w3-theme-d1";
}
</script>


   
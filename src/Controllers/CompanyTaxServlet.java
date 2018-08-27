package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dbUtility.DbInteractionUtility;
import dbUtility.ManagementUtility;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;


import Models.CompanyTax;


/**
 * Servlet implementation class CompanyTaxServlet
 */
@WebServlet("/CompanyTaxServlet")
public class CompanyTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyTaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Connection conn = ManagementUtility.getStoredConnection(request);
		 
	        String companyName = (String) request.getParameter("companyName");
	        String companyRegNo = (String) request.getParameter("companyRegNo");
	        String postalAddress = (String) request.getParameter("postalAddress");
	        String vatNumber = (String) request.getParameter("vatNumber");
	        String industry = (String) request.getParameter("industry");
	        String numberOfDirectorsStr = (String) request.getParameter("directors");



	        
	        int numberOfDirectors = 0;
	        try {
	            numberOfDirectors =Integer.parseInt(numberOfDirectorsStr);
	        } catch (Exception e) {
	        }
	        CompanyTax companyTax = new CompanyTax (companyName,companyRegNo,postalAddress,vatNumber,industry,numberOfDirectors);
	        
	        String errorString = null;
	 
	   
	 
	        if (errorString == null) {
	            try {
	                DbInteractionUtility.insertCompanyTaxRecord(conn,companyTax);
	            } catch (SQLException e) {
	                e.printStackTrace();
	                errorString = e.getMessage();
	            }
	        }
	 
	        // Store infomation to request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	 
	        // If error, forward to Edit page.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/Dashboard");
	            dispatcher.forward(request, response);
	        }
	        // If everything nice.
	        // Redirect to the product listing page.
	        else {
	            response.sendRedirect(request.getContextPath() + "/Dashboard");
	        }
	  	}

}

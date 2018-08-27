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


import Models.TaxPayer;



/**
 * Servlet implementation class incomeTaxServlet
 */
@WebServlet("/incomeTaxServlet")
public class incomeTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public incomeTaxServlet() {
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
		 
	        String firstName = (String) request.getParameter("firstName");
	        String lastName = (String) request.getParameter("lastName");
	        String postalAddress = (String) request.getParameter("postalAddress");
	        String residentialAddress = (String) request.getParameter("residentialAddress");
	        String DOB = (String) request.getParameter("dob");
	        String salaryString = (String) request.getParameter("salary");
	        String industry = (String) request.getParameter("industry");




	        
	        double salary = 0;
	        try {
	            salary =Double.parseDouble(salaryString);
	        } catch (Exception e) {
	        }
	        TaxPayer taxPayer = new TaxPayer(firstName,lastName,postalAddress,residentialAddress,industry,DOB,salary);
	        
	        String errorString = null;
	 
	   
	 
	        if (errorString == null) {
	            try {
	                DbInteractionUtility.insertIncomeTaxMember(conn, taxPayer);
	            } catch (SQLException e) {
	                e.printStackTrace();
	                errorString = e.getMessage();
	            }
	        }
	 
	        // Store infomation to request attribute, before forward to views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("product", taxPayer);
	 
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

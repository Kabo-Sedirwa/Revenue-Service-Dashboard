package Controllers;


 import java.io.IOException;

 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 
 import java.sql.Connection;
 import java.sql.SQLException;
 import java.util.List;
 
 import java.text.NumberFormat;


 import Models.*;
 import dbUtility.*;
 
 @WebServlet(urlPatterns = { "/Dashboard" })

public class DashboardServlet extends HttpServlet{


	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public DashboardServlet() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession();
	 
	        // Check User has logged on
	        User loginedUser = ManagementUtility.getLoginedUser(session);
	        
	        //Get database connection 
	        
	        Connection conn = ManagementUtility.getStoredConnection(request);	 
	        String errorString = null;
	        List<CompanyTax> companyList = null;
	        List<TaxPayer> incomeList = null;
	        String companyCount  = null;
	        String directorCount  = null;
	        String taxPayerTotal  = null;



	        
	        try {
	        	companyList = DbInteractionUtility.getAllCompanyTaxRecords(conn);
	        	incomeList  = DbInteractionUtility.getAllIncomeTaxRecords(conn);
	        	companyCount =Integer.toString(DbInteractionUtility.getCountOfCompanies(conn)) ;
	        	directorCount =Integer.toString(DbInteractionUtility.getCountOfCompanyDirectors(conn));
	        	taxPayerTotal =Integer.toString(DbInteractionUtility.getCountOfTaxPayers(conn));


	        	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        
	        
	        
	        
	        // Not logged in
	        if (loginedUser == null) {
	            // Redirect to login page.
	            response.sendRedirect(request.getContextPath() + "/home");
	            return;
	        }
	        // Store info to the request attribute before forwarding.
	        request.setAttribute("user", loginedUser);
	        request.setAttribute("companyRecords", companyList);
	        request.setAttribute("incomeTaxRecords", incomeList);
	        request.setAttribute("companyCount", companyCount);
	        request.setAttribute("directorCount", directorCount);
	        request.setAttribute("taxPayerTotal", taxPayerTotal);




	 
	        // If the user has logged in, then forward to the page
	        // /WEB-INF/views/Dashboard.jsp
	        RequestDispatcher dispatcher //
	                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Dashboard Pages/Dashboard.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	

}

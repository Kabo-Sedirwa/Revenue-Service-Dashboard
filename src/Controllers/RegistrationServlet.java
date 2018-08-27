 package Controllers;

 import java.io.IOException;
 import java.io.PrintWriter;
 import dbUtility.ManagementUtility;
 import java.io.IOException;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

 import Models.User;

 
 
 @WebServlet(urlPatterns = {"/Register"})


public class RegistrationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // TODO Auto-generated method stub
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  String firstName = request.getParameter("firstName");
		  String lastName = request.getParameter("lastName");
		  String email = request.getParameter("email");
		  String password = request.getParameter("password");
	      String rememberMeStr = request.getParameter("rememberMe");
	      boolean remember = "Y".equals(rememberMeStr);
		

		  // validate given input
		  if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
		   RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		   out.println("<font color=red>Please fill all the fields</font>");
		   rd.include(request, response);
		  } else {
			  
			  
			  String errorString = null;
			  
			  try {
		            Connection conn = ManagementUtility.getStoredConnection(request);
		            
		            
		            String checkEmailQuery = "Select Count(*) AS countRow from users " //
			                + " where email = '"+email+"'";
			 
			        PreparedStatement pstm = conn.prepareStatement(checkEmailQuery);
			        ResultSet rs = pstm.executeQuery();
			        
			        rs.next();
			        String rowCount = rs.getString(1);
			        
			        if(rowCount.equals(0)){
			        	
			            String sql = "Insert into users(firstName,lastName,email,password) values (?,?,?,?)";


					    PreparedStatement pstmRegister = conn.prepareStatement(sql);
					    
					    pstmRegister.setString(1, firstName);
					    pstmRegister.setString(2, lastName);
					    pstmRegister.setString(3, email);
					    pstmRegister.setString(4, password);

					    pstmRegister.executeUpdate();
					    System.out.println("successfuly inserted");
					    
					    
				
					   
				       User user = new User();
				   
				       user.setFirstName(firstName);
				       user.setLastName(lastName);
					   
					   HttpSession session = request.getSession();
					   ManagementUtility.storeRegisteredUser(session, user);
			 
			            // If user checked "Remember me".
			            if (remember) {
			            	ManagementUtility.storeUserCookie(response, user);
			            }
			            // Else delete cookie.
			            else {
			            	ManagementUtility.deleteUserCookie(response);
			            }
			 
			            // Redirect to userInfo page.
			            response.sendRedirect(request.getContextPath() + "/Dashboard");
			        	
			        	
			        	
			        } else{
			        	
			        	errorString = "This email address has already been used.";
			        	
			            request.setAttribute("errorString", errorString);
			            
			            request.getRequestDispatcher("/").forward(request, response);
	 

			        	
			        }
			 	  
		}catch(Exception e ){e.printStackTrace();}  
	   }
	  }
     }
    

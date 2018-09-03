package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import dbUtility.DbInteractionUtility;
import dbUtility.ManagementUtility;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.User;



@WebServlet(urlPatterns = {"/Login"})

public class LoginServlet extends HttpServlet {
	
		
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
			    String email = request.getParameter("email");
		        String password = request.getParameter("password");
		 
		 
		        User user = null;
		        boolean hasError = false;
		        String errorString = null;
		 
		        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
		            hasError = true;
		            errorString = "Required email and password!";
		        } else {
		            Connection conn = ManagementUtility.getStoredConnection(request);
		            try {
		                // Find the user in the DB.
		                user = DbInteractionUtility.findUser(conn, email, password);
		 
		                if (user == null) {
		                    hasError = true;
		                    errorString = "Email or password invalid";
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		                hasError = true;
		                errorString = e.getMessage();
		            }
		        }
		        // If error, forward to /WEB-INF/views/home.jsp
		        if (hasError) {
		            user = new User();
		            user.setEmail(email);
		            user.setPassword(password);
		 
		            // Store information in request attribute, before forward.
		            request.setAttribute("errorString", errorString);
		            request.setAttribute("user", user);
		 
		            // Forward to /WEB-INF/views/home.jsp
		            RequestDispatcher dispatcher //
		                    = this.getServletContext().getRequestDispatcher("/home");
		 
		            dispatcher.forward(request, response);
		        }
		        // If no error
		        // Store user information in Session
		        // And redirect to Dashboard.
		        else {
		            HttpSession session = request.getSession();
		            ManagementUtility.storeLoginedUser(session, user);
		 
		     
		 
		            // Redirect to Dashboard route.
		            response.sendRedirect(request.getContextPath() + "/Dashboard");
		        }
		    }
			 
		

}

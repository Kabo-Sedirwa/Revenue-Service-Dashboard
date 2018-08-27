 package dbUtility;
	
 import java.sql.Connection;
	
 import javax.servlet.ServletRequest;
 import javax.servlet.http.Cookie;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;

 import Models.User;

 public class ManagementUtility {
	
	
		 
	    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	 
	    private static final String ATT_NAME_FIRST_NAME = "ATTRIBUTE_FOR_STORE_FIRST_NAME_IN_COOKIE";
	    
	    private static final String ATT_NAME_LAST_NAME = "ATTRIBUTE_FOR_STORE_LAST_NAME_IN_COOKIE";

	 
	    // Store Connection in request attribute.
	    // (Information stored only exist during requests)
	    public static void storeConnection(ServletRequest request, Connection conn) {
	        request.setAttribute(ATT_NAME_CONNECTION, conn);
	    }
	 
	    // Get the Connection object has been stored in attribute of the request.
	    public static Connection getStoredConnection(ServletRequest request) {
	        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
	        return conn;
	    }
	 
	    // Store user info in Session.
	    public static void storeLoginedUser(HttpSession session, User loginedUser) {
	        // On the JSP can access via ${loginedUser}
	        session.setAttribute("loginedUser", loginedUser);
	    }
	    
	    // Store user info in Session.
	    public static void storeRegisteredUser(HttpSession session, User loginedUser) {
	        // On the JSP can access via ${loginedUser}
	        session.setAttribute("loginedUser", loginedUser);
	    }
	 
	    // Get the user information stored in the session.
	    public static User getLoginedUser(HttpSession session) {
	    	User loginedUser = (User) session.getAttribute("loginedUser");
	        return loginedUser;
	    }
	 
	    // Store info in Cookie
	    public static void storeUserCookie(HttpServletResponse response, User user) {
	        System.out.println("Store user cookie");
	        Cookie cookieFirstName = new Cookie(ATT_NAME_FIRST_NAME, user.getFirstName());
	        Cookie cookieLastName = new Cookie(ATT_NAME_LAST_NAME, user.getLastName());

	        // 1 day (Converted to seconds)
	        cookieFirstName.setMaxAge(24 * 60 * 60);
	        cookieLastName.setMaxAge(24 * 60 * 60);
	        
	        response.addCookie(cookieFirstName);
	        response.addCookie(cookieLastName);
	    }
	 
	    public static String getBothNamesInCookie(HttpServletRequest request) {
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (ATT_NAME_FIRST_NAME.equals(cookie.getName())&& ATT_NAME_LAST_NAME.equals(cookie.getName())) {
	                    return cookie.getValue();
	                }
	            }
	        }
	        return null;
	    }
	 
	    // Delete cookie.
	    public static void deleteUserCookie(HttpServletResponse response) {
	    	   Cookie cookieFirstName = new Cookie(ATT_NAME_FIRST_NAME, null);
		        Cookie cookieLastName = new Cookie(ATT_NAME_LAST_NAME, null);

	        // 0 seconds (This cookie will expire immediately)
		        cookieFirstName.setMaxAge(0);
		        cookieLastName.setMaxAge(0);

	        response.addCookie(cookieFirstName);
	        response.addCookie(cookieLastName);

	    }
	 
}

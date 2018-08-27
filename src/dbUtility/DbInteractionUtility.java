package dbUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.*;

public class DbInteractionUtility {
	
	
	   public static User findUser(Connection conn, //
	            String email, String password) throws SQLException {
	 
	        String sql = "Select * from users " //
	                + " where email = ? and password= ?";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, email);
	        pstm.setString(2, password);
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	        	
	            String lastName = rs.getString("lastName");
	            String firstName = rs.getString("firstName");


	            User user = new User();
	            user.setEmail(email);
	            user.setLastName(lastName);
	            user.setFirstName(firstName);
	            return user;
	        }
	        return null;
	    }
	   
	    public static User findUser(Connection conn, String email) throws SQLException {
	    	 
	        String sql = "Select * from users  "//
	                + " where email = ? ";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, email);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	            String lastName = rs.getNString("lastName");
	            String firstName = rs.getNString("firstName");
	            User user = new User();
	            user.setEmail(email);
	            user.setFirstName(firstName);
	            user.setLastName(lastName);
	            return user;
	        }
	        return null;
	    }
	 
	 
	    
	   
	 
	 
	    public static List<CompanyTax> getAllCompanyTaxRecords(Connection conn) throws SQLException {
	        String sql = "Select * from companyTax";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<CompanyTax> companyList = new ArrayList<CompanyTax>();
	        while (rs.next()) {
	            String companyName = rs.getString("companyName");
	            String companyRegNo = rs.getString("companyRegNo");
	            String postalAddress = rs.getString("postalAddress");
	            String vatNumber = rs.getString("vatNumber");
	            String industry = rs.getString("industry");
	            String numberOfDirectorsInt = rs.getString("directorsNo");

	            int numberOfDirectors = Integer.parseInt(numberOfDirectorsInt);

	            CompanyTax companyTax = new CompanyTax(companyName,companyRegNo,postalAddress,vatNumber,industry,numberOfDirectors);
	            companyTax.setCompanyName(companyName);
	            companyTax.setCompanyRegNo(companyRegNo);
	            companyTax.setPostalAddress(postalAddress);
	            companyTax.setVatNumber(vatNumber);
	            companyTax.setIndustry(industry);
	            companyTax.setNumberOfDirectors(numberOfDirectors);

	            companyList.add(companyTax);
	        }
	        return companyList;
	    }
	    
	    
	    
	    public static int getCountOfCompanies(Connection conn) throws SQLException {
	        String sql = "Select Count(*) AS companyTotal from companyTax";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        rs.next();
		    int companyCount = rs.getInt("companyTotal");
	            
	        return companyCount;
	        
	    }
	    
	    
	    public static int getCountOfTaxPayers(Connection conn) throws SQLException {
	        String sql = "Select Count(*) AS taxpayerTotal from incomeTax";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        rs.next();
		    int taxpPayerTotal = rs.getInt("taxpayerTotal");
	            
	        return taxpPayerTotal;
	        
	    }
	    
	    
	    public static int getCountOfCompanyDirectors(Connection conn) throws SQLException {
	        String sql = "Select SUM(directorsNo) AS directorTotal from companyTax";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        rs.next();
		    int directorTotal = rs.getInt("directorTotal");
	            
	        return directorTotal;
	        
	    }
	    
	    public static List<TaxPayer> getAllIncomeTaxRecords(Connection conn) throws SQLException {
	        String sql = "Select * from incomeTax";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        ResultSet rs = pstm.executeQuery();
	        List<TaxPayer> incomeTaxList = new ArrayList<TaxPayer>();
	        while (rs.next()) {
	            String firstName = rs.getString("firstName");
	            String lastName = rs.getString("lastName");
	            String postalAddress = rs.getString("postalAddress");
	            String residentialAddress = rs.getString("residentialAddress");
	            String industry = rs.getString("industry");
	            String DOB = rs.getString("DOB");
	            String salaryStrng = rs.getString("salary");

	            double salary = Double.parseDouble(salaryStrng);

	            TaxPayer incomeTax = new TaxPayer(firstName,lastName,postalAddress,residentialAddress,industry,DOB,salary);
	            incomeTax.setFirstName(firstName);
	            incomeTax.setLastName(lastName);
	            incomeTax.setPostalAddress(postalAddress);
	            incomeTax.setResidentialAddress(residentialAddress);
	            incomeTax.setIndustry(industry);
	            incomeTax.setDOB(DOB);
	            incomeTax.setSalary(salary);

	            incomeTaxList.add(incomeTax);
	        }
	        return incomeTaxList;
	    }
	 
	    /*
	  public static Product findProduct(Connection conn, String code) throws SQLException {
	        String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, code);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        while (rs.next()) {
	            String name = rs.getString("Name");
	            float price = rs.getFloat("Price");
	            TaxPayer product = new TaxPayer(code, name, price);
	            return product;
	        }
	        return null;
	    }
	 
	    public static void updateProduct(Connection conn, TaxPayer taxPayer) throws SQLException {
	        String sql = "Update Product set Name =?, Price=? where Code=? ";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, product.getName());
	        pstm.setFloat(2, product.getPrice());
	        pstm.setString(3, product.getCode());
	        pstm.executeUpdate();
	    }*/
	 
	    public static void insertIncomeTaxMember(Connection conn, TaxPayer taxPayer) throws SQLException {
	        String sql = "Insert into incomeTax(firstName,lastName,postalAddress,residentialAddress,industry,DOB,salary,timestamp) values (?,?,?,?,?,?,?,now())";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, taxPayer.getFirstName());
	        pstm.setString(2, taxPayer.getLastName());
	        pstm.setString(3, taxPayer.getPostalAddress());
	        pstm.setString(4, taxPayer.getResidentialAddress());
	        pstm.setString(5, taxPayer.getIndustry());
	        pstm.setString(6, taxPayer.getDOB());
	        pstm.setDouble(7, taxPayer.getSalary());

	 
	        pstm.executeUpdate();
	    }
	    
	    public static void insertCompanyTaxRecord(Connection conn, CompanyTax companyTax) throws SQLException {
	        String sql = "Insert into companyTax(companyName,companyRegNo,postalAddress,vatNumber,industry,directorsNo,timestamp) values (?,?,?,?,?,?,now())";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, companyTax.getCompanyName());
	        pstm.setString(2, companyTax.getCompanyRegNo());
	        pstm.setString(3, companyTax.getPostalAddress());
	        pstm.setString(4, companyTax.getVatNumber());
	        pstm.setString(5, companyTax.getIndustry());
	        pstm.setInt(6, companyTax.getNumberOfDirectors());

	 
	        pstm.executeUpdate();
	    }
	 
	    public static void deleteProduct(Connection conn, String code) throws SQLException {
	        String sql = "Delete From Product where Code= ?";
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, code);
	 
	        pstm.executeUpdate();
	    }

}

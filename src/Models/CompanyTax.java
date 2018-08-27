package Models;

public class CompanyTax {
	
	//Fields
	private String companyName;
	private String companyRegNo;
	private String postalAddress;
	private String vatNumber;
	private String industry;
	private int numberOfDirectors;
	
	
	//Constructor
	
	public CompanyTax(String companyName, String companyRegNo, String postalAddress, String vatNumber, String industry,
			int numberOfDirectors) {
		super();
		this.companyName = companyName;
		this.companyRegNo = companyRegNo;
		this.postalAddress = postalAddress;
		this.vatNumber = vatNumber;
		this.industry = industry;
		this.numberOfDirectors = numberOfDirectors;
	}
	
	
	//Getters and Setters 
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyRegNo() {
		return companyRegNo;
	}
	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public int getNumberOfDirectors() {
		return numberOfDirectors;
	}
	public void setNumberOfDirectors(int numberOfDirectors) {
		this.numberOfDirectors = numberOfDirectors;
	}

}

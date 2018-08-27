package Models;

public class TaxPayer {

    //Global Variables
	 private String firstName;
	 
   
	private String lastName;
	 private String postalAddress;
	 private String residentialAddress;
	 private String industry;
     private String DOB;
	 private double salary;
	 
	  public TaxPayer(String firstName, String lastName, String postalAddress, String residentialAddress, String industry,
				String dOB, double salary) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.postalAddress = postalAddress;
			this.residentialAddress = residentialAddress;
			this.industry = industry;
			DOB = dOB;
			this.salary = salary;
		}

	 
	 //Getters and Setters
		   
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


}

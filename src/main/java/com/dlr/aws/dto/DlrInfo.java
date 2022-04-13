package com.dlr.aws.dto;

public class DlrInfo {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String last4ssn;
	private String dlNumber;
	
	public DlrInfo() {
		
	}	
	
	public DlrInfo(String firstName, String middleName, String lastName, String last4ssn, String dlNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.last4ssn = last4ssn;
		this.dlNumber = dlNumber;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLast4ssn() {
		return last4ssn;
	}
	public void setLast4ssn(String last4ssn) {
		this.last4ssn = last4ssn;
	}
	public String getDlNumber() {
		return dlNumber;
	}
	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}

	@Override
	public String toString() {
		return "DlrInfo [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", last4ssn=" + last4ssn + ", dlNumber=" + dlNumber + "]";
	}	

}

package com.springMVC.example1.example1.Model;

public enum MaritalStatus {
	SINGLE("SINGLE"), MARRIED("MARRIED"), DIVORCEE("DIVORCEE"), WIDOWER("WIDOWER");
	// declaring private variable for getting values
	private String maritalStatus;

	// enum constructor - cannot be public or protected
	private MaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	// getter method
	public String getMaritalStatus() {
		return maritalStatus;
	}

}

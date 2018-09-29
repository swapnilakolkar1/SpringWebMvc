package com.springMVC.example1.example1.Model;

public enum BloodGroup{
	AN("A-"), AP("A+"), BN("B-"), BP("B+"), ON("O-"), OP("O+"), ABN("AB-"), ABP("AB+");
	// declaring private variable for getting values
	private String bloodGroup;

	// getter method
	public String getBloodGroup() {
		return this.bloodGroup;
	}

	// enum constructor - cannot be public or protected
	private BloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}

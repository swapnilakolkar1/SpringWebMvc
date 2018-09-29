package com.springMVC.example1.example1.Vo;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.springMVC.example1.example1.Model.Employee;

public class AppointmentVO {
	private Integer totalRecords;

	private List<Map<String, Employee>> listOfCandidates;

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Map<String, Employee>> getListOfCandidates() {
		return listOfCandidates;
	}

	public void setListOfCandidates(List<Map<String, Employee>> listOfCandidates) {
		this.listOfCandidates = listOfCandidates;
	}

}

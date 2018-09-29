package com.springMVC.example1.example1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.springMVC.example1.example1.Model.AddressVO;
import com.springMVC.example1.example1.Model.BloodGroup;
import com.springMVC.example1.example1.Model.Employee;
import com.springMVC.example1.example1.Model.MaritalStatus;
import com.springMVC.example1.example1.Vo.AppointmentVO;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private Faker faker;

	@RequestMapping(
		
			method = RequestMethod.GET,
			produces = { 
			MediaType.APPLICATION_XML_VALUE 
			}
	)
	public @ResponseBody Map<String, Employee> get() {
		Map<String, Employee> empMap = new HashMap<String, Employee>();
		for (int i = 0; i < 10; i++) {
			Employee e = new Employee();

			empMap.put("EMP_" + i, e);
		}
		return empMap;
	}

	@RequestMapping(
			value = "/{day}",
			method = RequestMethod.GET
		
	)
	public AppointmentVO getForDay(@PathVariable String day, Model model) {
		AppointmentVO appointMentCandidatesList = new AppointmentVO();
		Map<String, Employee> empMap = null;

		List<Map<String, Employee>> listOfCandidates = new ArrayList<>();
		int randomloopLimit = generateRandomNumber(100);
		for (int i = 0; i < randomloopLimit; i++) {
			Employee e = new Employee();
			empMap = new HashMap<String, Employee>();
			e.setFirstName(faker.name().firstName());
			e.setLastName(faker.name().lastName());
			e.setMiddleName(faker.name().firstName());
			e.setEmpDob(new Date(Math.abs(System.currentTimeMillis() - RandomUtils.nextLong())).toString());
			e.setBloodGroup(getBloodGroup());

			e.setAddress(getRandomAddress());

			e.setMaritalStatus(getMaritalStatus());
			empMap.put(faker.idNumber().valid(), e);
			listOfCandidates.add(empMap);
		}
		Integer totalRecords = listOfCandidates.size();
		appointMentCandidatesList.setListOfCandidates(listOfCandidates);
		appointMentCandidatesList.setTotalRecords(totalRecords);
		return appointMentCandidatesList;
	}

	private String getMaritalStatus() {
		MaritalStatus ms[] = MaritalStatus.values();
		int random = generateRandomNumber(4);
		String mStatus = ms[random].getMaritalStatus();
		return mStatus;
	}

	private String getBloodGroup() {
		BloodGroup bg[] = BloodGroup.values();
		int random = generateRandomNumber(8);
		String bGroup = bg[random].getBloodGroup();
		return bGroup;
	}

	private String getRandomName() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	private AddressVO getRandomAddress() {

		AddressVO address = new AddressVO();
		address.setBuildingNumber(faker.address().buildingNumber());
		address.setCity(faker.address().city());
		address.setCityName(faker.address().cityName());
		address.setCountry(faker.address().country());
		address.setLatitude(faker.address().latitude());
		address.setState(faker.address().state());
		address.setLongitude(faker.address().longitude());
		address.setStreetAddress(faker.address().streetAddress());
		address.setZipCode(faker.address().zipCode());
		return address;
	}

	private int generateRandomNumber(int limit) {
		return (int) (Math.random() * limit);
	}
}

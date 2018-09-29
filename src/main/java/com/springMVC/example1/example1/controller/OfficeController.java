package com.springMVC.example1.example1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class OfficeController {
	@RequestMapping("/office")
	public ModelAndView getOffice(@RequestParam(required = false, defaultValue = "ADP") String officeName) {
		// Employee emp1 = new Employee();
		Map<String, String> officeInfo = new HashMap<String, String>();
		officeInfo.put("officeName", officeName);
		officeInfo.put("officeAddress", "Hyderabad");
		officeInfo.put("NO of employees working", "more than 1000+");

		ModelAndView officeMV = new ModelAndView("office", officeInfo);

		return officeMV;
	}
}

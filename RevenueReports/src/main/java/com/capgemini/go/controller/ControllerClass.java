package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.entity.RevenueReport;
import com.capgemini.go.service.ServiceInterface;

@RestController
@RequestMapping("/Reports")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceInterface serviceobj;

	// Get RevenueReports
	@GetMapping("/RevenueReport/{date1}/{date2}/{category}")
	private ResponseEntity<List<RevenueReport>> viewDetailedSalesReportByProduct(@PathVariable("date1") String entry,@PathVariable("date2") String exit, @PathVariable("category") String category) {

		List<RevenueReport> revenueList = serviceobj.viewDetailedSalesReportByProduct(entry, exit, category);
		return new ResponseEntity<List<RevenueReport>>(revenueList, HttpStatus.OK);
	}

}

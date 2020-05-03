package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.entity.RevenueReport;

public interface ServiceInterface {
	
	List<RevenueReport> viewDetailedSalesReportByProduct(String entry,String exit,String category);

}

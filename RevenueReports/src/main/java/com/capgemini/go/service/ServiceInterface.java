package com.capgemini.go.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.go.entity.RevenueReport;

public interface ServiceInterface {
	
	List<RevenueReport> viewDetailedSalesReportByProduct(Date entry,Date exit,String category);

}

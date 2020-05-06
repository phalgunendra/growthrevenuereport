package com.capgemini.go.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.go.entity.RevenueTable;

public interface ServiceInterface {
	
	List<RevenueTable> viewSalesReportByUserAndCategory(Date entry,Date exit,String targetUserId,String category);

}

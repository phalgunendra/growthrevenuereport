package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.entity.RevenueTable;

public interface ServiceInterface {
	
	List<RevenueTable> viewSalesReportByUserAndCategory(String entry,String exit,String targetUserId,String category);

}

package com.capgemini.go.service;
 
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.DaoInterface;
import com.capgemini.go.entity.RevenueReport;
import com.capgemini.go.entity.RevenueTable;

@Service
@Transactional
public class ServiceClass implements ServiceInterface {
	@Autowired
	DaoInterface daoobj;

	@SuppressWarnings("deprecation")
	@Override
	public List<RevenueReport> viewDetailedSalesReportByProduct(Date entry,Date exit, String category) {

		List<RevenueTable> transactionList = daoobj.viewDetailedSalesReportByProduct(entry,exit, category);
		int i;
		int  j;
		int revenue = 0;
		int change = 0;
		int prev = 0;
		String period;
		String colorcode;
		ArrayList<RevenueReport> revenuelist = new ArrayList<>();
		for (i = 0; i < transactionList.size(); i++) {
			Date objdate = transactionList.get(i).getDate1();// getting date from object
			revenue = transactionList.get(i).getProduct_price();
			for (j = i + 1; j < transactionList.size(); j++) {
				Date objdate1 = transactionList.get(j).getDate1();
				if (objdate1.getMonth()==objdate.getMonth())
					revenue = revenue + transactionList.get(j).getProduct_price();
				else
					break;
			}
			// combining month,year as period
			period = new DateFormatSymbols().getMonths()[objdate.getMonth()] + " " + (objdate.getYear()+1900);
			if (prev == 0)
				change = revenue;
			else
				change = revenue - prev;
			// Calculating percentage growth
			int percentagegrowth = (change * 100) / revenue;
			// Indication of growth using color
			if (percentagegrowth > 10)
				colorcode = "green";
			else if (percentagegrowth > 2 && percentagegrowth <= 10)
				colorcode = "blue";
			else
				colorcode = "red";
			RevenueReport r = new RevenueReport(period, revenue, change, percentagegrowth, colorcode);
			revenuelist.add(r);
			i = j - 1;
			prev = revenue;
		}
		return revenuelist;
	}
}

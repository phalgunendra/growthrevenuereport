package com.capgemini.go.service;

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

	//To convert date format from yyyy-mm-dd to dd-mmm-yyyy
	String dateformat(String s) {
		String months = new DateFormatSymbols().getMonths()[Integer.parseInt(s.substring(5, 7)) - 1];
		String cdate = s.subSequence(8, 10) + "-" + months.substring(0, 3) + "-" + s.substring(0, 4);
		return cdate;
	}

	@Override
	public List<RevenueReport> viewDetailedSalesReportByProduct(String entry, String exit, String category) {

		List<RevenueTable> l3 = daoobj.viewDetailedSalesReportByProduct(dateformat(entry), dateformat(exit), category);
		int i, j, revenue = 0, change = 0, prev = 0;
		String period, colorcode;
		ArrayList<RevenueReport> revenuelist = new ArrayList<RevenueReport>();
		for (i = 0; i < l3.size(); i++) {
			String objdate = l3.get(i).getDate1();// getting date from object
			revenue = l3.get(i).getProduct_price();
			for (j = i + 1; j < l3.size(); j++) {
				String objdate1 = l3.get(j).getDate1();
				if (objdate1.subSequence(5, 7).equals(objdate.subSequence(5, 7)))
					revenue = revenue + l3.get(j).getProduct_price();
				else
					break;
			}
			// combining month,year as period
			period = new DateFormatSymbols().getMonths()[Integer.parseInt(objdate.substring(5, 7)) - 1] + " " + objdate.subSequence(0, 4);
			if (prev == 0)
				change = revenue;
			else
				change = revenue - prev;
			// Calculating percentage growth
			int percentagegrowth = (change * 100) / revenue;
			// Indication of growth using color
			if (percentagegrowth > 10)
				colorcode = "green";
			else if (percentagegrowth > 2 && percentagegrowth < 10)
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

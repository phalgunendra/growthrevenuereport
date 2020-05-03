package com.capgemini.go.service;

import java.text.DateFormatSymbols;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.DaoInterface;
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
	public List<RevenueTable> viewSalesReportByUserAndCategory(String entry, String exit, String targetUserId, String category) {
		return daoobj.viewSalesReportByUserAndCategory(dateformat(entry), dateformat(exit), targetUserId, category);
	}

}

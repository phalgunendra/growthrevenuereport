package com.capgemini.go.service;

import java.sql.Date;
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

	@Override
	public List<RevenueTable> viewSalesReportByUserAndCategory(Date entry, Date exit, String targetUserId, String category) {
		return daoobj.viewSalesReportByUserAndCategory(entry,exit, targetUserId, category);
	}

}

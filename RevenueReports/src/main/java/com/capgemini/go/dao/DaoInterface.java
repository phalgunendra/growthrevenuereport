package com.capgemini.go.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.go.entity.RevenueTable;

public interface DaoInterface extends JpaRepository<RevenueTable, Integer> {
	@Query("select r from RevenueTable r where r.date1>=?1 and r.date1<=?2 and r.product_category=?3  order by r.date1")
	List<RevenueTable> viewDetailedSalesReportByProduct(Date entry, Date exit, String category);

}

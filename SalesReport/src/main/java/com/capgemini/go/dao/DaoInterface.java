package com.capgemini.go.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.go.entity.RevenueTable;
public interface DaoInterface extends JpaRepository<RevenueTable,Integer>{
	@Query("select r from RevenueTable r where r.date1>=?1 and r.date1<=?2 and r.user_id=?3 and r.product_category=?4 order by date1")
	List<RevenueTable> viewSalesReportByUserAndCategory(Date entry, Date exit,String userid, String category);

}

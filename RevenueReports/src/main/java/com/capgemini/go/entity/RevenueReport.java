package com.capgemini.go.entity;

public class RevenueReport {

	private String period;
	private int revenue;
    private int change;
    private int percentagegrowth;
    private String colorcode;
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	public int getPercentagegrowth() {
		return percentagegrowth;
	}
	public void setPercentagegrowth(int percentagegrowth) {
		this.percentagegrowth = percentagegrowth;
	}
	public String getColorcode() {
		return colorcode;
	}
	public void setColorcode(String colorcode) {
		this.colorcode = colorcode;
	}
	public RevenueReport(String period, int revenue, int change, int percentagegrowth, String colorcode) {
		super();
		this.period = period;
		this.revenue = revenue;
		this.change = change;
		this.percentagegrowth = percentagegrowth;
		this.colorcode = colorcode;
	}
	
    
}

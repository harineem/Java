package com.hmn.fin;

public class PerFinDetail {
	
	
	private double monthlyexpense =0.0d;
	private double inflationrate =6.0d;
	private int retired_years = 0;
	public int getRetired_years() {
		return retired_years;
	}
	public void setRetired_years(int retired_years) {
		this.retired_years = retired_years;
	}
	private double currentsavings = 0.0d;
	private double savingsrate = 0.0d;
	private int savings_end_year = 0;
	private int years_to_retire =0;
	
	public int getYears_to_retire() {
		return years_to_retire;
	}
	public void setYears_to_retire(int years_to_retire) {
		this.years_to_retire = years_to_retire;
	}
	public double getMonthlyexpense() {
		return monthlyexpense;
	}
	public void setMonthlyexpense(double monthlyexpense) {
		this.monthlyexpense = monthlyexpense;
	}
	public double getInflationrate() {
		return inflationrate;
	}
	public void setInflationrate(double inflationrate) {
		this.inflationrate = inflationrate;
	}
	
	public double getCurrentsavings() {
		return currentsavings;
	}
	public void setCurrentsavings(double currentsavings) {
		this.currentsavings = currentsavings;
	}
	public double getSavingsrate() {
		return savingsrate;
	}
	public void setSavingsrate(double savingsrate) {
		this.savingsrate = savingsrate;
	}
	public int getSavings_end_year() {
		return savings_end_year;
	}
	public void setSavings_end_year(int savings_end_year) {
		this.savings_end_year = savings_end_year;
	}
	public PerFinDetail() {
		// TODO Auto-generated constructor stub
	}
	

}

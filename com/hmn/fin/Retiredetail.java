/**
 * 
 */
package com.hmn.fin;

import java.math.BigDecimal;

/**
 * @author harineem
 *
 */
public class Retiredetail {
	
	
	private BigDecimal retirementsum =new BigDecimal(0.0d);
	
	private int savings_end_year = 0;
	private BigDecimal sum_needed = new BigDecimal(0.0d);
	public int getSavings_end_year() {
		return savings_end_year;
	}


	public void setSavings_end_year(int savings_end_year) {
		this.savings_end_year = savings_end_year;
	}


	public BigDecimal getSum_needed() {
		return sum_needed;
	}


	public void setSum_needed(BigDecimal sum_needed) {
		this.sum_needed = sum_needed;
	}




	public BigDecimal getRetirementsum() {
		return retirementsum;
	}


	public void setRetirementsum(BigDecimal retirementsum) {
		this.retirementsum = retirementsum;
	}





	/**
	 * 
	 */
	public Retiredetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

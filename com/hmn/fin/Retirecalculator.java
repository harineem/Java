/**
 * 
 */
package com.hmn.fin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author harineem
 * @version 0.2
 * Purpose: Calculate the money you need to sustain after you retire and the years your savings will hold
 * Reason: Just wanted to see how lambdas make it so easy to code , practically 2 lines.
 */
public class Retirecalculator {

	/**
	 * 
	 */
	public Retirecalculator() {
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * The method which does the calculation
	 * @return RetireDetail the object which will contain all details on the retirement funds
	 *  
	 *@param PerFinDetail the object which contains all the financial details of the person
	
	 */
	public Retiredetail calculateDetailedSum(PerFinDetail perdetails) {
		
		Retiredetail detail = new Retiredetail();
		int years = perdetails.getYears_to_retire() + 
                perdetails.getRetired_years();
		
		double[] values = new double[years];
		double retirementsum = 0.0d;
		double savings = perdetails.getCurrentsavings();
		int years_savings_last = 0;
		//System.out.println(" detail "+ details.toString());
		
		//actual code which does the calculation, power of lambdas
		Arrays.parallelSetAll(values, i -> perdetails.getMonthlyexpense()*12*Math.pow((1+perdetails.getInflationrate() /100), i));
	    Arrays.parallelPrefix(values, Double::sum);
	    retirementsum = values[years-1];
	    
	    //calculate how long your savings will last
	    Arrays.parallelSetAll(values, e->{if((savings - values[e])<=0) {
	    	return 0;}
	    	else { return 1; } }) ;
	    years_savings_last = (int)Arrays.stream(values).filter(p->(p==1)).count();
	    detail.setSavings_end_year(years_savings_last);
	   

	    
	   
	    if(perdetails.getCurrentsavings()>0.0d ) {
	    	retirementsum = perdetails.getCurrentsavings()>retirementsum?
	    			0:(retirementsum-perdetails.getCurrentsavings());
	    	
	    } 
	    detail.setRetirementsum(BigDecimal.valueOf(retirementsum)
			    .setScale(2, RoundingMode.HALF_UP));
	    
	    return detail;
	  
	    
		
		
	}
	
	
	
}

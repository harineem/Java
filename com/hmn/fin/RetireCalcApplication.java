package com.hmn.fin;

import java.math.BigDecimal;
import java.util.Scanner;

public class RetireCalcApplication {

	public RetireCalcApplication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Use this if you want to run it as stand alone application else call the calculateSum method
	 * 
	 * @param args
	 */
	/**
	 * Use this if you want to run it as stand alone application else call the calculateSum method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		//BigDecimal retirementsum =new BigDecimal(0.0d);
		PerFinDetail persdetails = new PerFinDetail();
		Retiredetail rdetail = new Retiredetail();
		Retirecalculator rc = new Retirecalculator();
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(" Please enter your monthly expenses that you anticipate after you retire ");
		persdetails.setMonthlyexpense(sc.nextDouble());
		System.out.println(" Please enter expected inflation rate(default 6) if you think it will be 6%, then enter 6 ");
		persdetails.setInflationrate(sc.nextDouble());
		System.out.println(" Please enter number of years before you retire ");
		persdetails.setYears_to_retire(sc.nextInt());
		System.out.println(" Please enter years you expect to livein retirement ");
		persdetails.setRetired_years(sc.nextInt());
		System.out.println("Please enter any savings you may have   ");
		persdetails.setCurrentsavings(sc.nextDouble());
		
		rdetail =rc.calculateDetailedSum(persdetails );
		System.out.println("Funds needed for expenses post retirement "+ rdetail.getRetirementsum());
		 
		
		
		
		

	}
}

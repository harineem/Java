package com.hmn.thrd;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* Program to calculate primes to demonstrate usage of ForkJoinPool in Java */
public class CalculatingPrimes {

	public CalculatingPrimes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Building normal way
		System.out.println(" Processors "+Runtime.getRuntime().availableProcessors());
		int startnum =1;
		int endnum = 1000;
		
		//START with 1000 ,not much difference  there  in timings
		SimplePrimeNumber smp = new SimplePrimeNumber(startnum,endnum);
		long starttime = System.currentTimeMillis();
		System.out.println(" Prime count between "+startnum +" and "+endnum +" :  "+smp.calculatePrimeCount());
		System.out.println(" Time taken "+(System.currentTimeMillis()-starttime));
		// WIth fork join
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		ParallelPrimeNumber pmp = new ParallelPrimeNumber(startnum,endnum);
		starttime = System.currentTimeMillis();
		System.out.println(" Parallel prime count between "+startnum +" and "+endnum +" :  " +pool.invoke(pmp));
		System.out.println(" Time taken "+(System.currentTimeMillis()-starttime));
		
		// Go for bigger numbers then Parallel processing almost halves the time
		startnum =1;
		endnum = 10000000;
		smp.setStnum(startnum);
		smp.setEndnum(endnum);
		starttime = System.currentTimeMillis();
		System.out.println(" Prime count between "+startnum +" and "+endnum +" :  "+smp.calculatePrimeCount());
		System.out.println(" Time taken "+(System.currentTimeMillis()-starttime));
		// WIth fork join
		pmp = new ParallelPrimeNumber(startnum,endnum);
		starttime = System.currentTimeMillis();
		System.out.println(" Parallel prime count between "+startnum +" and "+endnum +" :  " +pool.invoke(pmp));
		System.out.println(" Time taken "+(System.currentTimeMillis()-starttime));
		
		


	}

}

 // Class which will use parallel processing for calculating primes.
  class ParallelPrimeNumber extends RecursiveTask<Integer> {
  
	  int stnum = 0; 
	  int endnum = 0; 
	  public int getStnum() {
		return stnum;
	}

	public void setStnum(int stnum) {
		this.stnum = stnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}
	
	  public ParallelPrimeNumber(int stnum,int endnum){
		  this.stnum = stnum; 
		  this.endnum =endnum;
	  }
  
	  @Override 
	  protected Integer compute() { 
		  int mid = 0;
		  int solution = 0;
		  if(endnum-stnum<100 ) { 
			  
			 solution = getPrimeCount(); 
			 return solution; 
		  } else {
			  mid = (stnum + endnum)/2;
			  ParallelPrimeNumber p1 = new ParallelPrimeNumber(stnum,mid); 
			  ParallelPrimeNumber p2 = new ParallelPrimeNumber(mid+1,endnum);
			  p1.fork();
			  p2.fork(); 
			  solution = p1.join()+p2.join(); 
			  return solution; 
	  }
	  
	  // TODO Auto-generated method stub
	  
	  } 
	  int getPrimeCount() { 
		  int primecount = 0;
		  if(endnum<=1) return 1;
			for(int i=stnum;i<endnum+1;i++) {
				if(checkPrime(i)&&(i!=1)) {
					
					primecount +=1;
				}
			}
			return primecount;
	  }
	  boolean checkPrime(int dnum) {
		  boolean isPrime = true; 
		  int prnum =(int)(Math.sqrt(Double.valueOf(dnum))); 
		  if(dnum==2 || dnum==3 || dnum==5 || dnum==7 || dnum==11) return true;
		  if(dnum%2==0 || dnum%3==0 || dnum%5==0 ||dnum%7==0 || dnum%10==0) return false; 
		  for(int i =11;i<prnum+1;i++) {
			  if(dnum%i==0) { 
				  return false; 
			  } 
		  }
		  return isPrime; 
		 }
	  
  	}
  
// Class which will use normal processing for calculating primes.
 
class SimplePrimeNumber {
	int stnum = 0;
	public int getStnum() {
		return stnum;
	}
	public void setStnum(int stnum) {
		this.stnum = stnum;
	}
	public int getEndnum() {
		return endnum;
	}
	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}
	int endnum = 0;
	int primecount = 0;
	public SimplePrimeNumber(int stnum,int endnum){
		this.stnum = stnum;
		this.endnum = endnum;
	
	}
	int calculatePrimeCount(){
		
		if(endnum<=1) return 1;
		for(int i=stnum;i<endnum+1;i++) {
			if(checkPrime(i)&&(i!=1)) {
				
				primecount +=1;
			}
		}
		return primecount;
	}
	boolean checkPrime(int dnum) {
		boolean isPrime = true;
		int prnum = (int)(Math.sqrt(Double.valueOf(dnum)));
		if(dnum==2 || dnum==3 || dnum==5 || dnum==7 || dnum==11) return true;
		if(dnum%2==0 || dnum%3==0 || dnum%5==0 || dnum%7==0 || dnum%10==0) return false;
		for(int i =11;i<prnum+1;i++) {
			if(dnum%i==0) {
				return false;
			}
		}
		return isPrime;
	}
	
	
}
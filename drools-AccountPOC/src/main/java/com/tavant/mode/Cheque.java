package com.tavant.mode;

import java.time.LocalDate;

import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Cheque {
	
	private int chequeNum;
	private double withdrawAmount;
	private	LocalDate  initiationDate;
	private boolean temp;
	
	public int getChequeNum() {
		return chequeNum;
	}
	public void setChequeNum(int chequeNum) {
		this.chequeNum = chequeNum;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public boolean isTemp() {
		return temp;
	}
	public void setTemp(boolean temp) {
		this.temp = temp;
	}
	
	
	public LocalDate getInitiationDate() {
		return initiationDate;
	}
	public void setInitiationDate(LocalDate initiationDate) {
		this.initiationDate = initiationDate;
	}
	public long compareDate()
	 {
		 
	      LocalDate ld=this.getInitiationDate();
	      LocalDate currentDate = LocalDate.now();
	     
	      long diffInDays = ChronoUnit.DAYS.between(ld, currentDate);
	      
	      return diffInDays;
	 }
	

}

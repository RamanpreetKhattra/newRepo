package com.tavant.main;

import java.util.Comparator;

import com.tavant.mode.Cheque;

public class SortByDateANdAmount implements Comparator<Cheque> {
	 
	public int compare(Cheque ch1, Cheque ch2)
	    {
		 
			if(ch1.compareDate() == ch2.compareDate()){
				//System.out.println("executing");
				if(ch1.getWithdrawAmount()<=ch2.getWithdrawAmount())
				return (int) (ch2.getWithdrawAmount() - ch1.getWithdrawAmount());
				
				return (int) (ch2.getWithdrawAmount() - ch1.getWithdrawAmount());
			}
			else if(ch1.compareDate() < ch2.compareDate())
				return (int) (ch1.compareDate()-ch2.compareDate());
	        
				return (int)(ch2.compareDate() - ch1.compareDate());
	    }

}

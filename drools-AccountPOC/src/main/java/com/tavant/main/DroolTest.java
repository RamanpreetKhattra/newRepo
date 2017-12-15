package com.tavant.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.tavant.mode.Account;
import com.tavant.mode.Cheque;
import com.tavant.mode.Product;

public class DroolTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Account account = new Account();
			Account account1 = new Account();
			Cheque cheque1 =  new Cheque();
			cheque1.setChequeNum(111);
			cheque1.setWithdrawAmount(100000);
			cheque1.setInitiationDate( LocalDate.of(2017,9,7));
			
			Cheque cheque2 =  new Cheque();
			cheque2.setChequeNum(222);
			cheque2.setWithdrawAmount(1500);
			cheque2.setInitiationDate( LocalDate.of(2017,9,7));
		
			Cheque cheque3 =  new Cheque();
			cheque3.setChequeNum(333);
			cheque3.setWithdrawAmount(500);
			cheque3.setInitiationDate( LocalDate.of(2017,9,7));
		
			List<Cheque> list = new ArrayList();
			list.add(cheque1);
			list.add(cheque2);
			list.add(cheque3);
			List<Cheque> list1 = new ArrayList();
			list1.add(cheque1);
			list1.add(cheque2);
			list1.add(cheque3);
	        Collections.sort(list, new SortByDateANdAmount());
	        System.out.println("================================");
	        Collections.sort(list1, new SortByDateANdAmount());
			account.setAccountBalance(10000);
			account.setAccountType("credit");
			account.setCheques(list);
			System.out.println("+++++++++++++++++++++++");
//			for(int i=0;i<list.size();i++)
//				System.out.println(list.get(i).getChequeNum());
			
			System.out.println("+++++++++++++++++++++++");
			account1.setAccountBalance(5000);
			account1.setAccountType("saving");
			account1.setCheques(list1);
			System.out.println("+++++++++++++++++++++++");
			for(int i=0;i<list1.size();i++)
				System.out.println(list1.get(i).getChequeNum());
			
			System.out.println("+++++++++++++++++++++++");
			
			FactHandle fact1;
			kSession.getAgenda().getAgendaGroup("group saving").setFocus();
			kSession.getAgenda().getAgendaGroup("group credit").setFocus();;
			kSession.insert(account1);
			kSession.insert(account);
			
			kSession.fireAllRules();
			
			//kSession.dispose();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}


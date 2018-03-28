package com.app.test;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.PaymentDao;
import com.app.dao.PaymentDaoFactory;
import com.app.domain.ChequePayment;
import com.app.domain.CreditCardPayment;
import com.app.domain.Payment;

public class PaymentTest {
	public static void main(String[] args) {	
		PaymentDao dao = null;
		// get the object from paymentDaoFactory class
		dao = PaymentDaoFactory.getInstance();
		
		/*// save the object
		try {
			dao.savePayment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//get all the payments details
		List<Payment> pList=null;
		try {
			pList=dao.getAllPayment();
			System.out.println("________________________________________________");
			System.out.println("Payment details...");
			System.out.println("________________________________________________");
			pList.forEach(p-> {
				System.out.println(p.getTxId()+"--------"+p.getAmount());
			});
			System.out.println("________________________________________________");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			List<ChequePayment> cpList=null;
			cpList=new ArrayList<ChequePayment>();
			cpList=dao.getAllChequePayment();
			System.out.println("________________________________________________");
			System.out.println("Cheque Payment details...");
			System.out.println("________________________________________________");
			cpList.forEach(cp-> {
				System.out.println(cp.getTxId()+"---------"+cp.getAmount()+"---------"+cp.getChequeNo()+"-------"+cp.getChequeType());
			});
			System.out.println("________________________________________________");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			List<CreditCardPayment> ccpList=null;
			//get all credit card payment details
			ccpList=new ArrayList<CreditCardPayment>();
			ccpList=dao.getAllCreditCardPayment();
			System.out.println("________________________________________________");
			System.out.println("Credit Card Payment details...");
			System.out.println("________________________________________________");
			ccpList.forEach(ccp-> {
				System.out.println(ccp.getTxId()+"--------"+ccp.getAmount()+"-------"+ccp.getCcNo()+"------"+ccp.getCcType());
			});
			System.out.println("________________________________________________");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

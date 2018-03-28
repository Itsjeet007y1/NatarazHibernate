package com.app.dao;

import java.util.List;

import com.app.domain.ChequePayment;
import com.app.domain.CreditCardPayment;
import com.app.domain.Payment;

public interface PaymentDao {
	public String savePayment()throws Exception;
	public List<Payment> getAllPayment() throws Exception;
	public List<ChequePayment> getAllChequePayment() throws Exception;
	public List<CreditCardPayment> getAllCreditCardPayment() throws Exception;
}

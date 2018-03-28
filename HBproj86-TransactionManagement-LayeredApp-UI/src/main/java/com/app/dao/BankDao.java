package com.app.dao;

import com.app.domain.Account;
import com.app.exception.InsufficientAccountBalanceException;
import com.app.exception.NonPositvieBalanceTransferException;

public interface BankDao {
	public Account getAccountDetailsByAccountNumber(int acno);
	public boolean transferMoney(int srcAcno,int destAcno,float amt) throws NonPositvieBalanceTransferException, InsufficientAccountBalanceException;
}

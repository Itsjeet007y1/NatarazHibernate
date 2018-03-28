package com.app.service;

import com.app.dao.BankDao;
import com.app.dao.BankDaoFactory;
import com.app.domain.Account;
import com.app.exception.InsufficientAccountBalanceException;
import com.app.exception.NonPositvieBalanceTransferException;

public class AccountServiceImpl implements AccountService {

	@Override
	public Account getAccountDetailsByAccNo(int acno) {
		BankDao dao=null;
		Account acc=null;
		//get dao object from dao factory class
		dao=BankDaoFactory.getInstance();
		//use dao
		acc=dao.getAccountDetailsByAccountNumber(acno);
		return acc;
	}

	@Override
	public boolean TransferMoney(int src, int dst, int amt) throws NonPositvieBalanceTransferException, InsufficientAccountBalanceException {
		BankDao dao=null;
		boolean flag=false;
		//get and use dao object
		dao=BankDaoFactory.getInstance();
		flag=dao.transferMoney(src, dst, amt);
		return flag;
	}
}

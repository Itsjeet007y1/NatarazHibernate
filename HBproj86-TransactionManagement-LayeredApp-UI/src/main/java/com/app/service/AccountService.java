package com.app.service;

import com.app.domain.Account;
import com.app.exception.InsufficientAccountBalanceException;
import com.app.exception.NonPositvieBalanceTransferException;

public interface AccountService {
	public Account getAccountDetailsByAccNo(int acno);
	public boolean TransferMoney(int src, int dst, int amt) throws NonPositvieBalanceTransferException, InsufficientAccountBalanceException;
}

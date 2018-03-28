package com.app.delegate;

import com.app.exception.InsufficientAccountBalanceException;

public class InsufficientAccountDelegate {
	public void checkForInsufficientAmmount(int amt1) throws InsufficientAccountBalanceException {
		if(amt1<=0) {
			InsufficientAccountBalanceException i=new InsufficientAccountBalanceException("Insufficient balance account balance in source to transfer.");	
			throw i;
		}
	}
}

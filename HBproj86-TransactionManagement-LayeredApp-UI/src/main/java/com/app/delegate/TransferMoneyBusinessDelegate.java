package com.app.delegate;

import com.app.exception.NonPositvieBalanceTransferException;

public class TransferMoneyBusinessDelegate {
	
	public void transferMoneyDelegate(int src, int dst, int amt) throws NonPositvieBalanceTransferException{
		if(amt<=0) {
			NonPositvieBalanceTransferException i=new NonPositvieBalanceTransferException("Please enter Non zero positive Amount To Transfer..");
			throw i;
		}
	}
}

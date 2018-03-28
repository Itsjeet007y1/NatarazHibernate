package com.app.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.delegate.InsufficientAccountDelegate;
import com.app.delegate.TransferMoneyBusinessDelegate;
import com.app.domain.Account;
import com.app.exception.InsufficientAccountBalanceException;
import com.app.exception.NonPositvieBalanceTransferException;
import com.app.service.AccountServiceImpl;

@WebServlet("/controller")
public class AccountController extends HttpServlet {

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String link=null;
		RequestDispatcher rd=null;
		AccountServiceImpl service=null;
		int ano=0;
		Account acc=null;
		//get Request parameter value
		link=req.getParameter("param");
		
		if(link.equalsIgnoreCase("link1")) {
			ano=Integer.parseInt(req.getParameter("acno"));
			//get the object of service class
			service=new AccountServiceImpl();
			acc=service.getAccountDetailsByAccNo(ano);
			rd=req.getRequestDispatcher("/Account1Detail.jsp");
			req.setAttribute("acc", acc);
			rd.forward(req, res);
		}
		
		else if(link.equalsIgnoreCase("link2")) {
			ano=Integer.parseInt(req.getParameter("acno"));
			//get the object of service class
			service=new AccountServiceImpl();
			acc=service.getAccountDetailsByAccNo(ano);
			rd=req.getRequestDispatcher("/Account2Detail.jsp");
			req.setAttribute("acc", acc);
			rd.forward(req, res);
		}
		
		else if(link.equalsIgnoreCase("link3")){ 
			int sno=0,dno=0;
			int amt=0;
			boolean flag=false;
			String msg=null;
			sno=Integer.parseInt(req.getParameter("sano"));
			dno=Integer.parseInt(req.getParameter("dano"));
			amt=Integer.parseInt(req.getParameter("balance"));
			//get the object of service class
			service=new AccountServiceImpl();
			//call the method
			try {
				TransferMoneyBusinessDelegate d=new TransferMoneyBusinessDelegate();
				InsufficientAccountDelegate i=new InsufficientAccountDelegate();
				acc=new Account();
				int amt1=acc.getBalance();
				try {
					i.checkForInsufficientAmmount(amt1);
				} catch (InsufficientAccountBalanceException e1) {
					msg=e1.getMessage();
					rd=req.getRequestDispatcher("/Transfer.jsp");
					req.setAttribute("msg", msg);
					rd.forward(req, res);
				}
				d.transferMoneyDelegate(sno, dno, amt);
				try {
					flag=service.TransferMoney(sno, dno, amt);
				} catch (InsufficientAccountBalanceException e) {
					e.printStackTrace();
				}
				if(flag)
					msg="Money Transfered Successfully. :)";
				else
					msg="Some Problem occured :( Please check.";
				rd=req.getRequestDispatcher("/Transfer.jsp");
				req.setAttribute("msg", msg);
				rd.forward(req, res);
			} catch (NonPositvieBalanceTransferException e) {
				msg=e.getMessage();
				rd=req.getRequestDispatcher("/Transfer.jsp");
				req.setAttribute("msg", msg);
				rd.forward(req, res);
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}

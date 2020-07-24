package com.wipro.ccbill.entity;

import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;

public class CreditCardBill {
	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	private String customerType;
	public CreditCardBill ()
	{
		
	}
	public CreditCardBill (String creditCardNo, String customerId,String customerType, Date billDate, Transaction monthTransactions[])
	{
		this.creditCardNo=creditCardNo;
		this.customerId=customerId;
		this.customerType=customerType;
		this.billDate=billDate;
		this.monthTransactions=monthTransactions;
	}
	
	public String validateData() throws InputValidationException
	{
		if(creditCardNo!=null && creditCardNo.length()==16 && customerId!=null && customerId.length()>=6)
		{
			return "valid";
		}
		else
		{
			throw new InputValidationException();
		}
		
	}

	
	public double getTotalAmount(String transactionType)
	{
		double total=0;
		for(int i=0;i<monthTransactions.length;i++)
		{
			if(creditCardNo.equals("1111111111111111")) {
			if(monthTransactions[i].getTransactionType().equals(transactionType))
			{
				//System.out.println(monthTransactions[i].getTransactionType()+"  hi   "+transactionType);
				total +=monthTransactions[i].getTransactionAmount(); 
			}
			if(!transactionType.equals("DB")&& !transactionType.equals("CR")&&!transactionType.equals("EMI"))
			{
				return 0;
			}
			}
			else if(creditCardNo.equals("2222222222222222")) {
				if(monthTransactions[i].getTransactionType().equals(transactionType))
				{
					//System.out.println(monthTransactions[i].getTransactionType()+"  hi   "+transactionType);
					total +=monthTransactions[i].getTransactionAmount(); 
				}
				if(!transactionType.equals("DB")&& !transactionType.equals("CR")&&!transactionType.equals("EMI"))
				{
					return 0;
				}
			}
			else {
				if(monthTransactions[i].getTransactionType().equals(transactionType))
				{
					//System.out.println(monthTransactions[i].getTransactionType()+"  hi   "+transactionType);
					total +=monthTransactions[i].getTransactionAmount(); 
				}
				if(!transactionType.equals("DB")&& !transactionType.equals("CR")&&!transactionType.equals("EMI"))
				{
					return 0;
				}
			}
		}
		return total;
	}
	public double calculateBillAmount()
	{
		try {
		if(validateData().equals("valid"))
		{
			if (monthTransactions.length>0)
			{
				double db =getTotalAmount("DB");
				System.out.println("DB "+db);
				double cr =getTotalAmount("CR");
				System.out.println("CR "+cr);
				double emi=getTotalAmount("EMI");
				System.out.println("EMI "+emi);
				double outstanding_amount =db-cr+emi;
				double Interest_calculated = (outstanding_amount * (19.9/100) / 12);
				if(customerType.equals("PREMIUM")) {
					Interest_calculated=Interest_calculated-(Interest_calculated*0.20);
				}
				else if(customerType.equals("REGULAR")) {
					Interest_calculated=Interest_calculated-(Interest_calculated*0.10);
				}
				return outstanding_amount+Interest_calculated;
			}
			else
			{
				return 0.0;
			}
		}
		else
		{
			return 0.0;
		}
		}
		catch(InputValidationException e)
		{
			e.toString();
		}
		return 0;
	}

	

}

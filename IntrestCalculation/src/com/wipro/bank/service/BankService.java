package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService  {
	private static final String String = null;
	public boolean validateData(float principal, int tenure,int age, String gender) 
	{
		try
		{
			if(principal>500 &&(tenure==5||tenure==10)&&(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("Female")))
				return true;
				else 
					throw new BankValidationException();
		}
		catch (BankValidationException e)
		{
			System.out.print(e);
			return false;
		}
			
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
		if (validateData( principal, tenure,age, gender) )
		{
			 RDAccount r =new  RDAccount(tenure, principal);
			 r.setInterest(age, gender);
			 System.out.println("amount deposited"+principal);
			 System.out.println("total amount"+r.calculateInterest());
			 
		}
	}
}

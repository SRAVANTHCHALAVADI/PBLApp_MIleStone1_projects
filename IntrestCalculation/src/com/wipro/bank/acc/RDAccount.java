package com.wipro.bank.acc;

public class RDAccount extends Account {
	int tenure;
	float principal;
	float q=0.0f;
	public RDAccount(int tenure, float principal)
	{
		this.tenure=tenure;
		this.principal=principal;
	}
	public float calculateAmountDeposited()
	{
		return (principal*tenure*12);
	}
	public float calculateInterest()
	{
		float r= rateOfInterest/100;
		int n=4;
		int ng=tenure*12;
		for(int i=0;i<ng;i++)
		{
			q+= principal *(float) (Math.pow((1+r/n),n*((ng-i)/12.0)) - 1);
		}
		
		return q;
	}
	
}


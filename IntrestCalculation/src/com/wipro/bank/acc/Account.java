package com.wipro.bank.acc;

public abstract class Account {
	int tenure;
	float principal;
	float rateOfInterest;
	public void setInterest(int age, String gender)
	{
		if ((age<60) &&(gender.equalsIgnoreCase("male"))) {
			rateOfInterest=9.8f;
		}
		if ((age>=60) &&(gender.equalsIgnoreCase("male"))) {
			rateOfInterest=10.5f;
		}
		if ((age<58) &&(gender.equalsIgnoreCase("female"))) {
			rateOfInterest=10.2f;
		}
		if ((age>=58) &&(gender.equalsIgnoreCase("female"))) {
			rateOfInterest=10.8f;
		}
		
	}
	public float calculateMaturityAmount(float totalPrincipleDeposited,float maturityInterest)
	{
		return (totalPrincipleDeposited+maturityInterest);
	}
	public abstract float calculateInterest();
	
		
	
	public abstract float calculateAmountDeposited();

}

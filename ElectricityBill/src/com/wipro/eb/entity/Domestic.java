package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		
		float bill=currentReading-previousReading;
		
		if(bill <= 50) {
			return (float)slabs[0]*bill;
		}
		else if(bill >50 && bill <= 100) {
			return (50*slabs[0])+((bill-50)*slabs[1]);
		}
		else 
			return (50*slabs[0])+(50*slabs[1])+((bill-100)*slabs[2]);
		
	}

}

package com.wipro.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		// TODO Auto-generated method stub
		float u=currentReading-previousReading,bill;
		if(u<50)
			bill=u*slabs[0];
		else if(u<100)
			bill=(50*slabs[0])+((u-50)*slabs[1]);
		else 
			bill=(50*slabs[0])+(50*slabs[1])+((u-100)*slabs[2]);
		if(bill>=10000)
		{
			return (float) (bill+bill*0.09);
		}
		else if(bill>=5000) {
			return (float) (bill+bill*0.06);
		}
		else {
			return (float) (bill+bill*0.02);
		}
	}

}

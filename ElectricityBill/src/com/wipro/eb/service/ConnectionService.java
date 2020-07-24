package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;

import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
			if(currentReading<0 || previousReading<0 || currentReading<previousReading) {
				throw new InvalidReadingException();
			}
			if(type.equals("Domestic") || type.equals("Commercial"))
				return true;
			else
				throw new InvalidConnectionException();
	}
	
	public String generateBill(int currentReading, int previousReading, String type) {
		float n = calculateBillAmt(currentReading,previousReading,type);
		if(n==-1.0)
			return "Incorrect Reading";
		else if(n==-2)
			return "Invalid ConnectionType";
		else {
			return "Amount to be paid:"+n;
		}
	}
	
	public float calculateBillAmt(int currentReading, int previousReading, String type) {
		try {
			if(validate(currentReading,previousReading,type)) {
			if(type.equals("Domestic")) {
				float[] f= {2.3f,4.2f,5.5f};
				Domestic dom = new Domestic(currentReading, previousReading,f);
				return dom.computeBill();
			}
			else if(type.equals("Commercial")){
				float[] f = {5.2f,6.8f,8.3f};
				Commercial com = new Commercial(currentReading, previousReading,f);
				return com.computeBill();
			}
			}
		}
		catch(InvalidReadingException ire){
			return -1;
		}
		catch(InvalidConnectionException ice) {
			return -2;
		}
		return 0;
}
}

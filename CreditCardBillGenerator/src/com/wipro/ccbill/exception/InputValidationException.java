package com.wipro.ccbill.exception;

public class InputValidationException extends Exception {
	public InputValidationException()
	{
		super();
	}
	public InputValidationException(String str)
	{
		super(str);
	}
	public String toString() 
	{
		return "Invalid Input Data";
	}
}

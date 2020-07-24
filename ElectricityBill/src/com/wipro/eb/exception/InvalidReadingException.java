package com.wipro.eb.exception;

public class InvalidReadingException extends Exception{
	public InvalidReadingException() {
		super();
	}
	public InvalidReadingException(String str) {
		super(str);
	}
	public String toString() {
		return "Incorrect Reading";
	}

}

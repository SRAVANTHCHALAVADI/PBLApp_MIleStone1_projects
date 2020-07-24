package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception {
	public InvalidConnectionException() {
		super();
	}
	public InvalidConnectionException(String str) {
		super(str);
	}
	public String toString() {
		return "Invalid ConnectionType";
	}

}

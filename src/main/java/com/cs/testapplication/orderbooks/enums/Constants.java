package com.cs.testapplication.orderbooks.enums;

public enum Constants {

	OPEN("Book is open for transaction"),
	CLOSE("Book is close for transaction");
	
	private final String constantValue;
	
	Constants(String constantValue) {
		this.constantValue = constantValue;
	}
	
	public String getConstantValue(){
		return constantValue;
	}	
}

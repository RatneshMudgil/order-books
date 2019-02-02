package com.cs.testapplication.orderbooks.requestdto;

public final class FinancialInstrumentDto {

    final private String instrumentName;

	public FinancialInstrumentDto(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getInstrumentName() { return instrumentName; }
}

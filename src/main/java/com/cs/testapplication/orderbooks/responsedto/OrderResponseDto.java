package com.cs.testapplication.orderbooks.responsedto;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderResponseDto {
	
    private Integer orderQuantity;

    private BigDecimal orderPrice;

    private Instant entryDate;

    private String financialInstrumentName;

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Instant getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Instant entryDate) {
		this.entryDate = entryDate;
	}

	public String getFinancialInstrumentName() {
		return financialInstrumentName;
	}

	public void setFinancialInstrumentName(String financialInstrumentName) { this.financialInstrumentName = financialInstrumentName;}
}

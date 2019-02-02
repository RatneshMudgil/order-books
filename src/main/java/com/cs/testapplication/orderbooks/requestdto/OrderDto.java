package com.cs.testapplication.orderbooks.requestdto;

import java.math.BigDecimal;
import java.time.Instant;

public final class OrderDto {

    final private Integer orderQuantity;

	// to check for limit price and market price
    final private BigDecimal orderPrice;

    // the date will be in GMT
    private Instant entryDate;

    final private FinancialInstrumentDto instrument;

    public OrderDto(Integer orderQuantity, BigDecimal orderPrice, Instant entryDate, FinancialInstrumentDto instrument) {
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.entryDate = entryDate;
        this.instrument = instrument;
    }

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public FinancialInstrumentDto getInstrument() {
		return instrument;
	}

    public Instant getEntryDate() {
        // Instant class is already immutable
        return entryDate;
    }
}
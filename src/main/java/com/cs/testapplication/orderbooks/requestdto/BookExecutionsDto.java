package com.cs.testapplication.orderbooks.requestdto;

import java.math.BigDecimal;

public class BookExecutionsDto {

	private Long executionId;
	
	private BigDecimal executionPrice;
	
	private OrderBookDto orderBookDto;

	public Long getExecutionId() {
		return executionId;
	}

	public void setExecutionId(Long executionId) {
		this.executionId = executionId;
	}

	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}

	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}

	public OrderBookDto getOrderBookDto() {
		return orderBookDto;
	}

	public void setOrderBookDto(OrderBookDto orderBookDto) {
		this.orderBookDto = orderBookDto;
	}
}

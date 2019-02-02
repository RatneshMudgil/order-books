package com.cs.testapplication.orderbooks.requestdto;

import java.util.ArrayList;
import java.util.List;

public class OrderBookDto {

    private List<OrderDto> orderDtoList;

    // bookStatus = true would mean order book is open
    private Boolean bookStatus;

    public Boolean getBookStatus() { return bookStatus; }

	public void setBookStatus(Boolean bookStatus) {	this.bookStatus = bookStatus; }

	public List<OrderDto> getOrderDtoList() { return orderDtoList; }

	void addOrderBooks(OrderDto book){
		if(this.getBookStatus().equals(Boolean.TRUE)){
			if(this.getOrderDtoList() == null)
				this.orderDtoList = new ArrayList<>();
			this.getOrderDtoList().add(book);
		}
	}

	void removeOrders(){}
}

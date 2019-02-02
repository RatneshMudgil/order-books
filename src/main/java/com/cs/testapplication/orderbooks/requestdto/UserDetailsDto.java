package com.cs.testapplication.orderbooks.requestdto;

import java.util.List;

public class UserDetailsDto {

    private String userName;

	private List<OrderBookDto> orderBookList;

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public List<OrderBookDto> getOrderBookList() {
		return orderBookList;
	}

	public void setOrderBookList(List<OrderBookDto> orderBookList) {
		this.orderBookList = orderBookList;
	}
}
package com.cs.testapplication.orderbooks.responsedto;

import java.util.ArrayList;
import java.util.List;

public class OrderBookResponseDto {
	
    private String bookStatus;

    private String orderBookName;

    private String userDetailName;

    private List<OrderResponseDto> orderResponseDtos;

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getOrderBookName() {
        return orderBookName;
    }

    public void setOrderBookName(String orderBookName) {
        this.orderBookName = orderBookName;
    }

    public String getUserDetailName() {
        return userDetailName;
    }

    public void setUserDetailName(String userDetailName) {
        this.userDetailName = userDetailName;
    }

    public List<OrderResponseDto> getOrderResponseDtos() {
        return orderResponseDtos;
    }

    public void setOrderResponseDtos(List<OrderResponseDto> orderResponseDtos) {
        this.orderResponseDtos = orderResponseDtos;
    }

    public void addOrderResponseDtos(OrderResponseDto orderResponseDto){
        if(this.getOrderResponseDtos() == null)
            this.orderResponseDtos = new ArrayList<>();
    }
}
package com.cs.testapplication.orderbooks.service;

import java.util.List;

import com.cs.testapplication.orderbooks.responsedto.OrderBookResponseDto;
import com.cs.testapplication.orderbooks.responsedto.OrderResponseDto;

public interface OrderService {

	OrderBookResponseDto getOrderBookDetails(String orderId);

    Integer updateOrderStatusForfinancialEntity(String financialInstrumentName);

    OrderResponseDto getOrderDetails(String orderId);

    Integer getAmountOfOrdersInOrderbook(String orderBookId);

    List<OrderResponseDto> getBiggestOrderDetail();
    
    List<OrderResponseDto> getSmallestOrderDetail();
    
    OrderResponseDto getEarliestOrder();

	OrderResponseDto getLastOrder();
}
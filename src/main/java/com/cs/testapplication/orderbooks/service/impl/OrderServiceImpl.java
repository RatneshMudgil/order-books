package com.cs.testapplication.orderbooks.service.impl;

import com.cs.testapplication.orderbooks.entity.Order;
import com.cs.testapplication.orderbooks.entity.OrderBook;
import com.cs.testapplication.orderbooks.enums.Constants;
import com.cs.testapplication.orderbooks.repository.OrderBookRepository;
import com.cs.testapplication.orderbooks.repository.OrderRepository;
import com.cs.testapplication.orderbooks.responsedto.OrderBookResponseDto;
import com.cs.testapplication.orderbooks.responsedto.OrderResponseDto;
import com.cs.testapplication.orderbooks.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    OrderBookRepository orderBookRepository;

    @Resource
    OrderRepository orderRepository;

	@Override
	public OrderBookResponseDto getOrderBookDetails(String orderBookId) {
//		Session session = HibernateUtil.getHibernateSession();
		OrderBookResponseDto orderBookResponseDto = mapOrderBookEntityDtoToWebDto(
				orderBookRepository.findById(Long.parseLong(orderBookId)).get());

		return orderBookResponseDto;
	}

	@Override
	public Integer updateOrderStatusForfinancialEntity(String financialInstrumentName) {
        Integer update = orderBookRepository.updateOrderStatusForfinancialEntity(financialInstrumentName);
        LOG.info("Update status is : " + update);
        return update;
	}

    @Override
    public OrderResponseDto getOrderDetails(String orderId) {
        OrderResponseDto orderResponseDto = mapOrderEntityDtoToWebDto(
        orderRepository.findById(Long.parseLong(orderId)).get());
        return orderResponseDto;
    }

    private OrderResponseDto mapOrderEntityDtoToWebDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderQuantity(order.getOrderQuantity());
        orderResponseDto.setOrderPrice(order.getOrderPrice());
        orderResponseDto.setFinancialInstrumentName(order.getFinancialInstrument().getInstrumentName());
        orderResponseDto.setEntryDate(order.getEntryDate().toInstant());
        return orderResponseDto;
    }

    private OrderBookResponseDto mapOrderBookEntityDtoToWebDto(OrderBook orderBook) {
		// TODO : This could be done by the Builder also, if the DTO is complicated
		// TODO : Need to put null checks

        OrderBookResponseDto orderBookResponseDto = new OrderBookResponseDto();
        orderBookResponseDto.setBookStatus(orderBook.getBookStatus().equals(Boolean.TRUE) ? Constants.OPEN.toString()
                : Constants.CLOSE.toString());
        orderBookResponseDto.setOrderBookName(orderBook.getOrderBookName());
        orderBookResponseDto.setUserDetailName(orderBook.getUserDetails().getUserName());

        orderBook.getOrderList().forEach(order -> {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setEntryDate(order.getEntryDate().toInstant());
            orderResponseDto.setFinancialInstrumentName(order.getFinancialInstrument().getInstrumentName());
            orderResponseDto.setOrderPrice(order.getOrderPrice());
            orderResponseDto.setOrderQuantity(order.getOrderQuantity());

            orderBookResponseDto.addOrderResponseDtos(orderResponseDto);
        });

		return orderBookResponseDto;
	}
}

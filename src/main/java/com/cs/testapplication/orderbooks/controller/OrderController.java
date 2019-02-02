package com.cs.testapplication.orderbooks.controller;

import com.cs.testapplication.orderbooks.responsedto.OrderBookResponseDto;
import com.cs.testapplication.orderbooks.responsedto.OrderResponseDto;
import com.cs.testapplication.orderbooks.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/getOrderBook",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderBookResponseDto> getOrderBook(@RequestParam("orderBookId") String orderBookId){

	 log.info("In the OrderController::getOrderBook " + orderBookId);
        OrderBookResponseDto orderBookResponseDto =
                orderService.getOrderBookDetails(orderBookId);
		
		return new ResponseEntity<>(orderBookResponseDto, HttpStatus.OK);
	}

    @RequestMapping(value = "/getOrderDetails",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseDto> getOrderDetails(@RequestParam("orderId") String orderId) {

        log.info("In the OrderController::getOrderDetails " + orderId);
        OrderResponseDto orderResponseDto =
                orderService.getOrderDetails(orderId);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateOrderStatus",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateOrderStatus(@RequestParam("financialEntityName") String financialEntityName){

        log.info("In the OrderController::updateOrderStatus " + financialEntityName);
        Integer updateStatus = orderService.updateOrderStatusForfinancialEntity(financialEntityName);

        return new ResponseEntity<>(updateStatus, HttpStatus.OK);
    }


}
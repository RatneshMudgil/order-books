package com.cs.testapplication.orderbooks.repository;

import com.cs.testapplication.orderbooks.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

	@Query("select o from Order o where o.orderQuantity = (select max(o1.orderQuantity) from Order o1) ")
    List<Order> getBiggestOrderDetail();
	
	@Query("select o from Order o where o.orderQuantity = (select min(o1.orderQuantity) from Order o1) ")
    List<Order> getSmallestOrderDetail();
}

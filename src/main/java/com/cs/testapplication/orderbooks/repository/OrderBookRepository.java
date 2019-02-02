package com.cs.testapplication.orderbooks.repository;

import com.cs.testapplication.orderbooks.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long>, JpaSpecificationExecutor<OrderBook> {

    @Modifying
    @Query("update  ")
    int updateOrderStatusForfinancialEntity(@Param("financialInstrumentName") String financialInstrumentName);

}

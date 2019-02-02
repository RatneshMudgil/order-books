package com.cs.testapplication.orderbooks.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "ORDER")
@Immutable
public class Order extends VersionObject{

    @Id
//    @SequenceGenerator(allocationSize = 1, name = "BOOK", sequenceName = "ORDERBOOK_SEQ") //TODO
    @GenericGenerator(name = "BOOK", strategy = "increment")
    @GeneratedValue(generator = "BOOK")
    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ORDER_QUANTITY")
    private Integer orderQuantity;

    @Column(name = "ORDER_PRICE")
    private BigDecimal orderPrice;

    @Column(name = "ENTRY_DATE")
    private Timestamp entryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INSTRUMENT_ID", referencedColumnName = "INSTRUMENT_ID", nullable = false)
    private FinancialInstrument financialInstrument;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_BOOK_ID")
    private OrderBook orderBook;

    public Order(Integer orderQuantity, BigDecimal orderPrice, Timestamp entryDate, FinancialInstrument financialInstrument, OrderBook orderBook) {
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.entryDate = entryDate;
        this.financialInstrument = financialInstrument;
        this.orderBook = orderBook;
    }

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public FinancialInstrument getFinancialInstrument() {
        return financialInstrument;
    }

    public OrderBook getOrderBook() {
        return orderBook;
    }
}
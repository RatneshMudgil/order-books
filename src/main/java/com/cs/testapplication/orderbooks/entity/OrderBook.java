package com.cs.testapplication.orderbooks.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "ORDER_BOOK")
public class OrderBook {

    @Id
    @GenericGenerator(name = "ORDERBOOK", strategy = "increment")
    @GeneratedValue(generator = "ORDERBOOK")
    @Column(name = "ORDER_BOOK_ID")
    private Long orderBookId;

    @Column(name = "ORDER_BOOK_NAME")
    private String orderBookName;

    @Column(name = "BOOK_STATUS")
    @Type(type = "true_false")
    private Boolean bookStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private UserDetails userDetails;

    @OneToMany(mappedBy = "orderBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orderList;

    public Long getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(Long orderBookId) {
        this.orderBookId = orderBookId;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getOrderBookName() {
        return orderBookName;
    }

    public void setOrderBookName(String orderBookName) {
        this.orderBookName = orderBookName;
    }
}

package com.cs.testapplication.orderbooks.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "USER_DETAILS")
public class UserDetails extends VersionObject{

    @Id
    @SequenceGenerator(allocationSize = 1, name = "UD", sequenceName = "USERDETAILS_SEQ") //TODO
    @GeneratedValue(generator = "UD")
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderBook> orderBookList;

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public Set<OrderBook> getOrderBookList() {return orderBookList;}

    public void setOrderBookList(Set<OrderBook> orderBookList) {this.orderBookList = orderBookList;}
}

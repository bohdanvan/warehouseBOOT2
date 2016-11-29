package com.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by user on 19.11.2016.
 */
@Entity
public class OrderIncDel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String productName;
    private String url;
    private int qty;
    private double price;
    private double amount;


    @JsonIgnore
    @ManyToOne/*(targetEntity = IncDel.class)/*(fetch = FetchType.EAGER)*/
    private IncDel incDelJOIN;


    public OrderIncDel() {

    }

    public OrderIncDel(String productName, String url) {  // FIXME: 24.11.2016 DELETE this constr
        this.productName = productName;
        this.url = url;
    }





    public IncDel getIncDelJOIN() {
        return incDelJOIN;
    }

    public void setIncDelJOIN(IncDel incDelJOIN) {
        this.incDelJOIN = incDelJOIN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

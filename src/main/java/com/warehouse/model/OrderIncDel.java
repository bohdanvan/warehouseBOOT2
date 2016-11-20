package com.warehouse.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private int price;


//    @ManyToOne(targetEntity = IncDel.class)/*(fetch = FetchType.EAGER)*/
//    IncDel incDelJOIN;


    public OrderIncDel() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

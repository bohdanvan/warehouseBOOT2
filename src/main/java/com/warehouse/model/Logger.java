package com.warehouse.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String status;
    private String description;
    private long dateTime;
    private String date;


    @ManyToOne/*(fetch = FetchType.EAGER)*/
    IncDel incDelJOIN;



    public Logger() {
    }


    public Logger(String status, String description, IncDel incDelJOIN) {

        this.status = status;
        this.description = description;
        this.incDelJOIN = incDelJOIN;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy : HH-mm");
        this.date = sdf.format(new Date());
        this.dateTime = System.currentTimeMillis();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateL) {
        this.dateTime = dateL;
    }

    public IncDel getIncDelJOIN() {
        return incDelJOIN;
    }

    public void setIncDelJOIN(IncDel incDel) {
        this.incDelJOIN = incDel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

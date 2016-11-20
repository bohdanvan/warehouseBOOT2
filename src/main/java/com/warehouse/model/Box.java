//package com.warehouse.model;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table//(name="boxes")
//public class Box {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private int weight;
//    private int volWeight;
//    private double cost;
//    private int height;
//    private int lenght;
//    private int wight;
//    private String number;
//    private int numBoxInсDel;
//    private String status;
//    private String damageStatus;
//    private String description;
//
////    @OneToMany(mappedBy = "boxJOIN", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
////    private List<Parcel> parcels = new ArrayList<Parcel>();
//
//
//
///*
//    @OneToMany(mappedBy = "boxJOIN", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Recipient> recipients = new ArrayList<Recipient>();
//*/
//
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    private IncDel incDelJOIN;
//
//
//    public Box() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public int getVolWeight() {
//        return volWeight;
//    }
//
//    public void setVolWeight(int volWeight) {
//        this.volWeight = volWeight;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getLenght() {
//        return lenght;
//    }
//
//    public void setLenght(int lenght) {
//        this.lenght = lenght;
//    }
//
//    public int getWight() {
//        return wight;
//    }
//
//    public void setWight(int wight) {
//        this.wight = wight;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public int getNumBoxInсDel() {
//        return numBoxInсDel;
//    }
//
//    public void setNumBoxInсDel(int numBoxInсDel) {
//        this.numBoxInсDel = numBoxInсDel;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getDamageStatus() {
//        return damageStatus;
//    }
//
//    public void setDamageStatus(String damageStatus) {
//        this.damageStatus = damageStatus;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public IncDel getIncDelJOIN() {
//        return incDelJOIN;
//    }
//
//    public void setIncDelJOIN(IncDel incDelJOIN) {
//        this.incDelJOIN = incDelJOIN;
//    }
//}

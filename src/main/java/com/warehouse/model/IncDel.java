package com.warehouse.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class IncDel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String number;
    private double weight;
    private double volWeight;
    private int boxQty;
    private String warehouseID;
    private String destinationFROM;
    private String employeeID;
    private String userID;                      // employee login
    private String date;
    @Size(min = 2 , message = "size min 2 ")
    private String supplier;
    private String supplierInvoice;
    private String supplierPackList;
    private String currierCompany;
    private String currierTrackNumber;
    private String infoComment;
    private String infoStop;
    private String status;
    private String customsType;
    private String shippingType;
    private long lastIdForRegistration;

    //    @OneToMany(mappedBy = "incDelJOIN", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany(targetEntity = OrderIncDel.class)
//    private List<OrderIncDel> ordersListJOIN = new ArrayList<>();
    @OneToMany(mappedBy = "incDelJOIN")
    private Set<OrderIncDel> ordersHashSetJOIN = new HashSet<>();

    public void addOrder(OrderIncDel orderIncDel) {

        ordersHashSetJOIN.add(orderIncDel);
    }
//    @ManyToOne/*(fetch = FetchType.EAGER)*/
//    private User userJOIN;

    //    @OneToMany(targetEntity = Logger.class )
    @OneToMany(mappedBy = "incDelJOIN", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Logger> loggersListJOIN = new ArrayList<Logger>();

    public void addLog(Logger logger) {
        logger.setIncDelJOIN(this);
        loggersListJOIN.add(logger);

        if (!loggersListJOIN.contains(logger)) {

        }
    }

//       @OneToMany(targetEntity = Box.class)   // как вариант
//    @OneToMany(mappedBy = "incDelJOIN", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<Box> boxes = new ArrayList<Box>();


    public IncDel() {
    }

    public Set<OrderIncDel> getOrdersHashSetJOIN() {
        return ordersHashSetJOIN;
    }

    public void setOrdersHashSetJOIN(Set<OrderIncDel> ordersListJOIN) {
        this.ordersHashSetJOIN = ordersListJOIN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolWeight() {
        return volWeight;
    }

    public void setVolWeight(double volWeight) {
        this.volWeight = volWeight;
    }

    public int getBoxQty() {
        return boxQty;
    }

    public void setBoxQty(int boxQty) {
        this.boxQty = boxQty;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getDestinationFROM() {
        return destinationFROM;
    }

    public void setDestinationFROM(String destinationFROM) {
        this.destinationFROM = destinationFROM;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(String supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public String getSupplierPackList() {
        return supplierPackList;
    }

    public void setSupplierPackList(String supplierPackList) {
        this.supplierPackList = supplierPackList;
    }

    public String getCurrierCompany() {
        return currierCompany;
    }

    public void setCurrierCompany(String currierCompany) {
        this.currierCompany = currierCompany;
    }

    public String getCurrierTrackNumber() {
        return currierTrackNumber;
    }

    public void setCurrierTrackNumber(String currierTrackNumber) {
        this.currierTrackNumber = currierTrackNumber;
    }

    public String getInfoComment() {
        return infoComment;
    }

    public void setInfoComment(String infoComment) {
        this.infoComment = infoComment;
    }

    public String getInfoStop() {
        return infoStop;
    }

    public void setInfoStop(String infoStop) {
        this.infoStop = infoStop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomsType() {
        return customsType;
    }

    public void setCustomsType(String customsType) {
        this.customsType = customsType;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public long getLastIdForRegistration() {
        return lastIdForRegistration;
    }

    public void setLastIdForRegistration(long lastIdForRegistration) {
        this.lastIdForRegistration = lastIdForRegistration;
    }
//
//    public User getUserJOIN() {
//        return userJOIN;
//    }
//
//    public void setUserJOIN(User userJOIN) {
//        this.userJOIN = userJOIN;
//    }

    public List<Logger> getLoggersListJOIN() {
        return loggersListJOIN;
    }

    public void setLoggersListJOIN(List<Logger> loggersListJOIN) {
        this.loggersListJOIN = loggersListJOIN;
    }


}



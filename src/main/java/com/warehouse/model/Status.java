package com.warehouse.model;

public enum Status {

    ACTIVE("active"),
    INACTIVE("inactive"),
    DELETED("deleted"),
    LOCKED("locked");

    private String state;


    public void setState(String state) {
        this.state = state;
    }




    Status(final String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.state;
    }
}

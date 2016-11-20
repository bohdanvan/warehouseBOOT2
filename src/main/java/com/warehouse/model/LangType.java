package com.warehouse.model;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LangType {

    EN("eng"),
    AZ("aze");


    private String locale;

    static private String status;

    public void setLocale(String locale) {
        status = Status.ACTIVE.getState();
        this.locale = locale;
    }



    LangType(final String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getName() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.locale;
    }



}

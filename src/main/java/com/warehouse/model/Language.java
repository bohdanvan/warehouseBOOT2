package com.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 02.11.2016.
 */
@Entity
public class Language {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String locale;
    private boolean isSwitch;


    public Language() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isSwitch() {
        return isSwitch;
    }

    public void setSwitch(boolean aSwitch) {
        isSwitch = aSwitch;
    }



//
//    public static void main(String[] args) {
//
//        String country = "", language = "";
//
//        System.out.println("1 – Английский");
//
//        System.out.println("2 – Белорусский");
//
//        System.out.println("Любой символ – Русский");
//
//        char i = 0;
//
//        try {
//
//            i = (char) System.in.read();
//
//        } catch (IOException e1) {
//
//            e1.printStackTrace();
//
//        }
//
//        switch (i) {
//
//            case '1':
//
//            country = "US";
//
//            language = "EN";
//
//            break;
//
//            case '2':
//
//            country = "BY";
//
//            language = "BEL";
//
//        }
//
//        Locale current = new Locale(language, country);
//
//        ResourceBundle rb =
//
//                ResourceBundle.getBundle("text", current);
//
//        try {
//
//            String st = rb.getString("str1");
//
//            String s1 =
//
//                    new String(st.getBytes("ISO-8859-1"), "UTF-8");
//
//            System.out.println(s1);
//
//            st = rb.getString("str2");
//
//            String s2 =
//
//                    new String(st.getBytes("ISO-8859-1"), "UTF-8");
//
//            System.out.println(s2);
//
//        } catch (UnsupportedEncodingException e) {
//
//            e.printStackTrace();
//
//        }
//
//    }

}




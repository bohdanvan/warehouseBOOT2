package com.warehouse.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 07.12.2016.
 */
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;
    private String country;

    @OneToMany(targetEntity = User.class)
    List<User> usersListJOIN = new ArrayList<>();







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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<User> getUsersListJOIN() {
        return usersListJOIN;
    }

    public void setUsersListJOIN(List<User> usersListJOIN) {
        this.usersListJOIN = usersListJOIN;
    }
}

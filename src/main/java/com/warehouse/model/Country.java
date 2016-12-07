package com.warehouse.model;

import javax.persistence.*;

/**
 * Created by user on 03.10.2016.
 */
@Entity
@Table(name = "countrycode")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String aplha2;
    String aplha3;
    String continent;
    String continentPart;
    String iss00;
    String nameEN;
    String nameFullRU;
    String nameRU;

    public Country() {

    }

    public Country(String aplha2, String iss00, String nameEN) {
        this.aplha2 = aplha2;
        this.iss00 = iss00;
        this.nameEN = nameEN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAplha2() {
        return aplha2;
    }

    public void setAplha2(String aplha2) {
        this.aplha2 = aplha2;
    }

    public String getAplha3() {
        return aplha3;
    }

    public void setAplha3(String aplha3) {
        this.aplha3 = aplha3;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinentPart() {
        return continentPart;
    }

    public void setContinentPart(String continentPart) {
        this.continentPart = continentPart;
    }

    public String getIss00() {
        return iss00;
    }

    public void setIss00(String iss00) {
        this.iss00 = iss00;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameFullRU() {
        return nameFullRU;
    }

    public void setNameFullRU(String nameFullRU) {
        this.nameFullRU = nameFullRU;
    }

    public String getNameRU() {
        return nameRU;
    }

    public void setNameRU(String nameRU) {
        this.nameRU = nameRU;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (iss00 != country.iss00) return false;
        if (aplha2 != null ? !aplha2.equals(country.aplha2) : country.aplha2 != null) return false;
        if (aplha3 != null ? !aplha3.equals(country.aplha3) : country.aplha3 != null) return false;
        return nameEN != null ? nameEN.equals(country.nameEN) : country.nameEN == null;

    }


}

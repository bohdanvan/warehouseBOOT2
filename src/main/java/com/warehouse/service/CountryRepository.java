package com.warehouse.service;

import com.warehouse.model.Country;
import com.warehouse.model.IncDel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 11.11.2016.
 */
public interface CountryRepository extends JpaRepository<Country,Long> {


}


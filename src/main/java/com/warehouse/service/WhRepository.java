package com.warehouse.service;

import com.warehouse.model.IncDel;
import com.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by user on 11.11.2016.
 */
public interface WhRepository extends JpaRepository<Warehouse,Long> {

//    Optional<Warehouse> findByNumber(String number);
    Warehouse findByNumber(String number);
}


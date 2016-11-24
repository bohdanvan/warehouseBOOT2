package com.warehouse.service;

import com.warehouse.model.IncDel;
import com.warehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by user on 11.11.2016.
 */
public interface IncDelRepository extends JpaRepository<IncDel,Long> {

    Optional<IncDel> findByNumber(String number);
}


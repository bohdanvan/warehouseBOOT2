package com.warehouse.service;

import com.warehouse.model.IncDel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by user on 11.11.2016.
 */
public interface IncDelCrudRepository extends CrudRepository<IncDel,Long> {

    Optional<IncDel> findByNumber(String number);
}


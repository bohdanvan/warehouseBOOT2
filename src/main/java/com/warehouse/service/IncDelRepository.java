package com.warehouse.service;

import com.warehouse.model.IncDel;
import com.warehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by user on 11.11.2016.
 */
public interface IncDelRepository extends JpaRepository<IncDel,Long> {

//    List<IncDel> findByUserJOIN(User user); // FIXME: 14.11.2016
    IncDel findByNumber(String number);
}


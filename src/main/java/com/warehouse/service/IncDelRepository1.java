package com.warehouse.service;

import com.warehouse.model.IncDel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 11.11.2016.
 */
public interface IncDelRepository1 extends JpaRepository<IncDel,Long> {

//    List<IncDel> findByUserJOIN(User user); // FIXME: 14.11.2016
    IncDel findByNumber(String number);
}


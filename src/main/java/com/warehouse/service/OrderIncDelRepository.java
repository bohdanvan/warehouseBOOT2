package com.warehouse.service;

import com.warehouse.model.IncDel;
import com.warehouse.model.OrderIncDel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by user on 11.11.2016.
 */
public interface OrderIncDelRepository extends JpaRepository<OrderIncDel,Long> {
    Collection<OrderIncDel> findByIncDelJOIN(IncDel incDel);


}


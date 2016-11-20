package com.warehouse.service;

import com.warehouse.model.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 13.11.2016.
 */
public interface LoggerRepository extends JpaRepository<Logger,Long> {


}

package com.warehouse.service;


import com.warehouse.model.UserFullInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 11.11.2016.
 */
public interface UserFullInfoRepository extends JpaRepository<UserFullInfo,Long> {


}


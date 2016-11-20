package com.warehouse.service;

import com.warehouse.model.Language;
import com.warehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by user on 28.09.2016.
 */
@Repository
public interface LangRepository extends JpaRepository<Language,Long> {


}

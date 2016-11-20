package com.warehouse.service;

import com.warehouse.model.IncDel;

import java.util.List;

/**
 * Created by user on 13.11.2016.
 */
public interface IncDelService {

    void add(IncDel incDel);
    IncDel addIncDel(IncDel incDel);

    void save(IncDel incDel);
    IncDel saveIncDel(IncDel incDel);

    void delete(IncDel incDel);
    int delete(long id);

    IncDel findById(long id);

    List<IncDel> findAll();
    List<IncDel> findAll(int setMaxResult);
    List<IncDel> findByPrincipal();
    List<IncDel> findByPrincipal(int setMaxResult);
    List<IncDel> findByPrincipal(String principal);
    List<IncDel> findByPrincipal(String principal, int setMaxResult);
    List<IncDel> listByPattern(String field, String pattern);

    List<IncDel> listByPattern(String reqClass, String field, String pattern);
    List<IncDel> listByPattern(String reqClass, String field, String pattern, int setMaxResult);

}

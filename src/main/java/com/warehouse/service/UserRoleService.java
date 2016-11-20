package com.warehouse.service;

import com.warehouse.model.UserRole;


import java.util.List;

public interface UserRoleService {

    List<UserRole> findAll();

    UserRole findByTypeRole(String type);

    UserRole findById(long id);
}

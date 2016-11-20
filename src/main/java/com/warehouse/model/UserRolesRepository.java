package com.warehouse.model;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
    // TODO: 16.11.2016    // FIXME: 14.11.2016 b.userRolesList
    @Query("select role.role from UserRole role, User user where user.userName=?1 and role.userJOIN.userId=user.userId")
    public List<String> findRoleByUserid(String username);
	
}

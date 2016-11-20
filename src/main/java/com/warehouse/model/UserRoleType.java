package com.warehouse.model;

public enum UserRoleType {
    USER("USER"),
    DBA("DBA"),
    CLIENT("CLIENT"),
    CUSTOMS("CUSTOMS"),
    ADMIN("ADMIN");

    String userRoleType;

    UserRoleType(String userRoleType) {
        this.userRoleType = userRoleType;
    }

    public String getUserRoleType() {
        return userRoleType;
    }

}

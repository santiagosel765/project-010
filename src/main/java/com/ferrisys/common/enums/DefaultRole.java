package com.ferrisys.common.enums;

public enum DefaultRole {
    USER(1),
    ADMIN(2);

    private final Integer id;

    DefaultRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

package com.eco.sklad.domain;

import org.springframework.security.core.GrantedAuthority;

public enum ListRole implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

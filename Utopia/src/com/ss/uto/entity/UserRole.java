package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRole implements Serializable {

    private static final long serialVersionUID = 2983892676401476993L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return getId().equals(userRole.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

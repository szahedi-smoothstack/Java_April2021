package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class AirplaneType implements Serializable {

    private static final long serialVersionUID = 478262423083452567L;
    private Integer id;
    private Integer maxCapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneType that = (AirplaneType) o;
        return getId().equals(that.getId()) && getMaxCapacity().equals(that.getMaxCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMaxCapacity());
    }

}

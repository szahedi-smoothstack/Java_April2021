package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class Airplane implements Serializable {

    private static final long serialVersionUID = 3304129925586005133L;
    private Integer id;
    private AirplaneType airplaneType = new AirplaneType();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return getId().equals(airplane.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class Airport implements Serializable {

    private static final long serialVersionUID = 2699442484825460618L;
    private String iataId;
    private String city;

    public String getIataId() {
        return iataId;
    }

    public void setIataId(String iataId) {
        this.iataId = iataId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return getIataId().equals(airport.getIataId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIataId());
    }
}

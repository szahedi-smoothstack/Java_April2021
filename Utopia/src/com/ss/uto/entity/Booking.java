package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable {

    private static final long serialVersionUID = -8996407842789427919L;
    private Integer id;
    private Byte is_active;
    private String confirmationCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIs_active() {
        return is_active;
    }

    public void setIs_active(Byte is_active) {
        this.is_active = is_active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getId().equals(booking.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

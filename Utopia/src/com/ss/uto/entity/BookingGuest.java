package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookingGuest implements Serializable {

    private static final long serialVersionUID = -591647177473773765L;
    private Booking booking = new Booking();
    private String email;
    private String phone;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingGuest that = (BookingGuest) o;
        return getBooking().equals(that.getBooking()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getEmail(), getPhone());
    }
}

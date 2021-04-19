package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookingUser implements Serializable {

    private static final long serialVersionUID = 8124373916364702853L;
    private Booking booking = new Booking();
    private User user;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingUser that = (BookingUser) o;
        return getBooking().equals(that.getBooking()) && getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getUser());
    }
}

package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookingAgent implements Serializable {

    private static final long serialVersionUID = 6920815243091653101L;
    private Booking booking = new Booking();
    private User agent = new User();

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingAgent that = (BookingAgent) o;
        return getBooking().equals(that.getBooking()) && getAgent().equals(that.getAgent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getAgent());
    }
}

package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class FlightBookings implements Serializable {

    private static final long serialVersionUID = -5809321089730685644L;
    private Flight flight = new Flight();
    private Booking booking = new Booking();

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBookings that = (FlightBookings) o;
        return getFlight().equals(that.getFlight()) && getBooking().equals(that.getBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getBooking());
    }
}

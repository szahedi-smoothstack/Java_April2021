package com.ss.uto.entity;

import java.io.Serializable;
import java.util.Objects;

public class BookingPayment implements Serializable {

    private static final long serialVersionUID = 1813436866966766794L;
    private Booking booking = new Booking();
    private String stripeId;
    private Byte refunded;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public Byte getRefunded() {
        return refunded;
    }

    public void setRefunded(Byte refunded) {
        this.refunded = refunded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingPayment that = (BookingPayment) o;
        return getBooking().equals(that.getBooking()) && getStripeId().equals(that.getStripeId()) && getRefunded().equals(that.getRefunded());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooking(), getStripeId(), getRefunded());
    }
}

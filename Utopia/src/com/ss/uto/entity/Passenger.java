package com.ss.uto.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Passenger implements Serializable {

    private static final long serialVersionUID = -59538482289878735L;
    private Integer id;
    private Booking booking = new Booking();
    private String givenName;
    private String familyName;
    private String dob;
    private String gender;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return getId().equals(passenger.getId()) && getBooking().equals(passenger.getBooking()) && getGivenName().equals(passenger.getGivenName()) && getFamilyName().equals(passenger.getFamilyName()) && getDob().equals(passenger.getDob()) && getGender().equals(passenger.getGender()) && getAddress().equals(passenger.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBooking(), getGivenName(), getFamilyName(), getDob(), getGender(), getAddress());
    }
}

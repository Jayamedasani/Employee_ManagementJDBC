package org.example.models;

import java.util.Objects;

public class Address {
    private int id,employee_id;
    private String houseno,street,city,state;

    public Address() {
    }

    public Address(int id, int employee_id, String houseno, String street, String city, String state) {
        this.id = id;
        this.employee_id = employee_id;
        this.houseno = houseno;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(houseno, address.houseno) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, houseno, street, city, state);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", houseno='" + houseno + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

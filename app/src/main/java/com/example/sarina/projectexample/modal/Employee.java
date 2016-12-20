package com.example.sarina.projectexample.modal;

import java.io.Serializable;

/**
 * Created by Sarina on 12/18/2016.
 */

public class Employee implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phone;

    public Employee() {

    }

    public Employee(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

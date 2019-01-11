package com.example.sajad.cofeyab.model;

/**
 * Created by sajad on 8/22/2018.
 */
public class Information {
    private String location;
    private String telphone;
    private String address;

    public Information(String location, String telphone, String address) {
        setLocation(location);
        setTelphone(telphone);
        setAddress(address);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

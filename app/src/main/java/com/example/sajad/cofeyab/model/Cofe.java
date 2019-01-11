package com.example.sajad.cofeyab.model;

/**
 * Created by sajad on 8/21/2018.
 */
public class Cofe {
    private String name;
    private String location;
    private String address;
    private String imageUrl;
    private String phone;

    public Cofe(String name, String location, String imageUrl) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public Cofe(String name, String location, String address, String imageUrl, String phone) {
        setName(name);
        setLocation(location);
        setAddress(address);
        setImageUrl(imageUrl);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

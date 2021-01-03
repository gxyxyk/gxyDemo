package com.pojo;

import java.io.Serializable;

public class Address implements Serializable{
    private String addressName;
    private Integer addressNum;

    public Address() {
    }

    public Address(String addressName, Integer addressNum) {
        this.addressName = addressName;
        this.addressNum = addressNum;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                ", addressNum=" + addressNum +
                '}';
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(Integer addressNum) {
        this.addressNum = addressNum;
    }
}

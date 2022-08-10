package com.model;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String gender;
    private int addressId;
    private String dob;

    public User(int id,String name,String gender,int addressId,String dob) {
        this.id = id;
        this.name=name;
        this.gender=gender;
        this.addressId=addressId;
        this.dob=dob;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", addressId=" + addressId +
                ", dob='" + dob + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && addressId == user.addressId && name.equals(user.name) && gender.equals(user.gender) && dob.equals(user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, addressId, dob);
    }
}

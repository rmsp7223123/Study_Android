package com.example.and09_fragmentadapter.recycler;

public class RecyclerDTO {
    private int imgRes, age;
    private String gender, name, address;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public RecyclerDTO(int imgRes, int age, String gender, String name, String address) {
        this.imgRes = imgRes;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.address = address;
    }
}

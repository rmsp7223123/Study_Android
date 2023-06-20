package com.example.boardtest;

public class AccountDTO {
    private String user_id, user_pw, name, email;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountDTO(String user_id, String user_pw, String name, String email) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.name = name;
        this.email = email;
    }
}

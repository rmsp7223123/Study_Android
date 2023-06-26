package com.example.project01_mbjtalk.chat;

public class ChatDTO {
    private int imgRes;
    private String name, cnt, msg, date;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ChatDTO(int imgRes, String name, String cnt, String msg, String date) {
        this.imgRes = imgRes;
        this.name = name;
        this.cnt = cnt;
        this.msg = msg;
        this.date = date;
    }
}

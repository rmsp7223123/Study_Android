package com.example.and09_fragmentadapter.melon;

public class MelonDTO {
    private int imgRes, rank;
    private String song, singer;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public MelonDTO(int imgRes, int rank, String song, String singer) {
        this.imgRes = imgRes;
        this.rank = rank;
        this.song = song;
        this.singer = singer;
    }
}

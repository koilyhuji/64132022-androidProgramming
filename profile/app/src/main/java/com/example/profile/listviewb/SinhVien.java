package com.example.profile.listviewb;

public class SinhVien {
    String ten;
    String lop;
    int avatarImgId;
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getAvatarImgId() {
        return avatarImgId;
    }

    public void setAvatarImgId(int avatarImgId) {
        this.avatarImgId = avatarImgId;
    }

    public SinhVien(String ten, String lop, int imgid) {
        this.ten = ten;
        this.lop = lop;
        this.avatarImgId = imgid;
    }
}

package com.cg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class TruongDTO {
    private Long MaTruong;

    private String TenTruong;
    private String DiaChi;
    private String SoDT;

    public TruongDTO() {
    }

    public TruongDTO(Long maTruong, String tenTruong, String diaChi, String soDT) {
        MaTruong = maTruong;
        TenTruong = tenTruong;
        DiaChi = diaChi;
        SoDT = soDT;
    }

    public Long getMaTruong() {
        return MaTruong;
    }

    public void setMaTruong(Long maTruong) {
        MaTruong = maTruong;
    }

    public String getTenTruong() {
        return TenTruong;
    }

    public void setTenTruong(String tenTruong) {
        TenTruong = tenTruong;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }
}

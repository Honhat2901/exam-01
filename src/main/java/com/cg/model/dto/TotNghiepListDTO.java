package com.cg.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TotNghiepListDTO {
    private String tenTruong;
    private String tenNganh;
    private String soCMND;
    private String hoTen;
    private String email;
    private String soDT;
    private String diaChi;
    private String heTN;
    private String ngayTN;
    private String loaiTN;

    public TotNghiepListDTO() {
    }

    public TotNghiepListDTO(String tenTruong, String tenNganh) {
        this.tenTruong = tenTruong;
        this.tenNganh = tenNganh;
    }

    public TotNghiepListDTO(String tenTruong, String tenNganh, String soCMND, String hoTen, String email, String soDT, String diaChi, String heTN, String ngayTN, String loaiTN) {
        this.tenTruong = tenTruong;
        this.tenNganh = tenNganh;
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHeTN() {
        return heTN;
    }

    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }

    public String getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(String ngayTN) {
        this.ngayTN = ngayTN;
    }

    public String getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }
}

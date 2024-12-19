package com.cg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "SinhVien")
public class SinhVien {

    @Id
    @Pattern(regexp = "^\\d{14}$", message = "Vui lòng nhập đúng số CMND (14 chữ số)")
    private String soCMND;

    @NotBlank(message = "Vui lòng nhập họ tên")
    private String hoTen;

    @NotBlank(message = "Vui lòng nhập email")
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Vui lòng nhập đúng số điện thoại (10 chữ số)")
    private String soDT;
    private String diaChi;

    public SinhVien() {
    }

    public SinhVien(String soCMND, String hoTen, String email, String soDT, String diaChi) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
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
}

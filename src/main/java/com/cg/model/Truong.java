package com.cg.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "truong")
public class Truong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTruong;

    @NotBlank(message = "Vui lòng nhập tên trường")
    private String tenTruong;

    @NotBlank(message = "Vui lòng nhập địa chỉ")
    private String diaChi;

    @Pattern(regexp = "^\\d{10}$", message = "Vui lòng nhập đúng số điện thoại (10 chữ số)")
    private String soDT;

    public Truong() {
    }

    public Truong(Long maTruong, String tenTruong, String diaChi, String soDT) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public Long getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(Long maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    @Override
    public String toString() {
        return "Truong{" +
                "MaTruong=" + maTruong +
                ", TenTruong='" + tenTruong + '\'' +
                ", DiaChi='" + diaChi + '\'' +
                ", SoDT='" + soDT + '\'' +
                '}';
    }
}

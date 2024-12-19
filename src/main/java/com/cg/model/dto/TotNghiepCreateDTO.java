package com.cg.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class TotNghiepCreateDTO {
    private Long maTruong;
    private Long maNganh;
    private String soCMND;

    @NotBlank(message = "Vui lòng nhập họ tên")
    private String hoTen;

    @NotBlank(message = "Vui lòng nhập email")
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Vui lòng nhập đúng số điện thoại (10 chữ số)")
    private String soDT;
    private String diaChi;

    private String heTN;
    private String ngayTN;
    private String loaiTN;

    public TotNghiepCreateDTO() {
    }

    public TotNghiepCreateDTO(Long maTruong, Long maNganh, String soCMND, String heTN, String ngayTN, String loaiTN) {
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.soCMND = soCMND;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public Long getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(Long maTruong) {
        this.maTruong = maTruong;
    }

    public Long getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Long maNganh) {
        this.maNganh = maNganh;
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

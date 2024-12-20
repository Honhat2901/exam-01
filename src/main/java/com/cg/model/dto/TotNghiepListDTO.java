package com.cg.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class TotNghiepListDTO {
    private String tenTruong;
    private String tenNganh;
    private String soCMND;
    private String hoTen;
    private String heTN;
    private LocalDate ngayTN;
    private String loaiTN;

    public TotNghiepListDTO() {
    }

    public TotNghiepListDTO(String tenTruong, String tenNganh, String soCMND, String hoTen, String heTN, LocalDate ngayTN, String loaiTN) {
        this.tenTruong = tenTruong;
        this.tenNganh = tenNganh;
        this.soCMND = soCMND;
        this.hoTen = hoTen;
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

    public String getHeTN() {
        return heTN;
    }

    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }

    public LocalDate getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(LocalDate ngayTN) {
        this.ngayTN = ngayTN;
    }

    public String getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }
}

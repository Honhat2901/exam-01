package com.cg.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "totNghiep")
@IdClass(TotNghiepID.class)
public class TotNghiep {

    @Id
    private String soCMND;

    @Id
    private Long maTruong;

    @Id
    private Long maNganh;

    private String heTN;
    private LocalDate ngayTN;
    private String loaiTN;

    public TotNghiep() {
    }

    public TotNghiep(String soCMND, Long maTruong, Long maNganh, String heTN, LocalDate ngayTN, String loaiTN) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
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

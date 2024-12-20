package com.cg.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cong_viec")
@IdClass(CongViecID.class)
public class CongViec {
    @Id
    private String soCMND;

    private LocalDate ngayVaoCongTy;

    @Id
    private Long maNganh;

    private String tenCongViec;
    private String tenCongTy;
    private String diaChiCongTy;
    private Long thoiGianLamViec;

    public CongViec() {
    }

    public CongViec(String soCMND, Long maNganh, String tenCongViec, String tenCongTy) {
        this.soCMND = soCMND;
        this.maNganh = maNganh;
        this.tenCongViec = tenCongViec;
        this.tenCongTy = tenCongTy;
    }

    public CongViec(String soCMND, LocalDate ngayVaoCongTy, Long maNganh, String tenCongViec, String tenCongTy, String diaChiCongTy, Long thoiGianLamViec) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
        this.maNganh = maNganh;
        this.tenCongViec = tenCongViec;
        this.tenCongTy = tenCongTy;
        this.diaChiCongTy = diaChiCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public LocalDate getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(LocalDate ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public Long getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Long maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public Long getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(Long thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}

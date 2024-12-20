package com.cg.model.dto;


import java.time.LocalDate;

public class CongViecDTO {
    private String soCMND;
    private String tenNganh;
    private LocalDate ngayVaoCongTy;
    private String tenCongViec;
    private String tenCongTy;
    private String diaChiCongTy;
    private Long thoiGianLamViec;

    public CongViecDTO() {
    }

    public CongViecDTO(String soCMND, String tenNganh, LocalDate ngayVaoCongTy, String tenCongViec, String tenCongTy, String diaChiCongTy, Long thoiGianLamViec) {
        this.soCMND = soCMND;
        this.tenNganh = tenNganh;
        this.ngayVaoCongTy = ngayVaoCongTy;
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

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public LocalDate getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(LocalDate ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
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

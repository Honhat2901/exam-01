package com.cg.model.dto;


public class CongViecCreateDTO {
    private String soCMND;
    private String ngayVaoCongTy;
    private Long maNganh;
    private String tenCongViec;
    private String tenCongTy;
    private String diaChiCongTy;
    private Long thoiGianLamViec;

    public CongViecCreateDTO() {
    }

    public CongViecCreateDTO(String soCMND, String ngayVaoCongTy, Long maNganh, String tenCongViec, String tenCongTy, String diaChiCongTy, Long thoiGianLamViec) {
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

    public String getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(String ngayVaoCongTy) {
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

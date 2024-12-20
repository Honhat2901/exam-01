package com.cg.model.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CongViecCreateDTO {
    @Pattern(regexp = "^\\d{14}$", message = "Vui lòng nhập đúng số CMND (14 chữ số)")
    private String soCMND;

    private String hoTen;

    @NotBlank(message = "Vui lòng nhập ngày vào công ty")
    private String ngayVaoCongTy;
    private Long maNganh;

    @NotBlank(message = "Vui lòng nhập tên công việc")
    private String tenCongViec;

    @NotBlank(message = "Vui lòng nhập tên công ty")
    private String tenCongTy;

    @NotBlank(message = "Vui lòng nhập địa chỉ công ty")
    private String diaChiCongTy;

    @Pattern(regexp = "^\\d+$", message = "Vui lòng nhập đúng thời gian làm việc")
    private String thoiGianLamViec;

    public CongViecCreateDTO() {
    }

    public CongViecCreateDTO(String soCMND, String hoTen, String ngayVaoCongTy, Long maNganh, String tenCongViec, String tenCongTy, String diaChiCongTy, String thoiGianLamViec) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(String thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}

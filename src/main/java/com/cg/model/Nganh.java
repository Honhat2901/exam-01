package com.cg.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "nganh")
public class Nganh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNganh;

    @NotBlank(message = "Vui lòng nhập tên ngành")
    private String tenNganh;

    @NotBlank(message = "Vui lòng nhập loại ngành")
    private String loaiNganh;

    public Nganh() {
    }

    public Nganh(Long maNganh, String tenNganh, String loaiNganh) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.loaiNganh = loaiNganh;
    }

    public Long getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Long maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getLoaiNganh() {
        return loaiNganh;
    }

    public void setLoaiNganh(String loaiNganh) {
        this.loaiNganh = loaiNganh;
    }
}

package com.cg.model;

import java.io.Serializable;

public class TotNghiepID implements Serializable {
    private String soCMND;

    private Long maTruong;

    private Long maNganh;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

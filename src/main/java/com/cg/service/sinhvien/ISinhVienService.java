package com.cg.service.sinhvien;

import com.cg.model.SinhVien;
import com.cg.service.BaseService;

import java.util.Optional;

public interface ISinhVienService extends BaseService<SinhVien, Long> {

    Boolean existsBySoCMND(String SoCMND);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndSoCMNDNot(String email, String soCMND);

    Optional<SinhVien> findBySoCMND(String soCMND);

}

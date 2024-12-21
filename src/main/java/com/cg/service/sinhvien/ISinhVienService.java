package com.cg.service.sinhvien;

import com.cg.model.SinhVien;
import com.cg.service.IBaseService;

import java.util.List;
import java.util.Optional;

public interface ISinhVienService extends IBaseService<SinhVien, Long> {

    Boolean existsBySoCMND(String SoCMND);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndSoCMNDNot(String email, String soCMND);

    Optional<SinhVien> findBySoCMND(String soCMND);

    List<SinhVien> searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(String keyWord);

}

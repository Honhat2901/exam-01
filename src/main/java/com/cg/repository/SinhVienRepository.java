package com.cg.repository;

import com.cg.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    Boolean existsBySoCMND(String SoCMND);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndSoCMNDNot(String email, String soCMND);

    Optional<SinhVien> findBySoCMND(String soCMND);

    List<SinhVien> searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(String soCMND, String hoTen, String email, String soDT);
}

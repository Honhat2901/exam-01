package com.cg.repository;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, CongViecID> {

    List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String soCMND, String tenCongViec, String tenCongTy);
}

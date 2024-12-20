package com.cg.repository;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import com.cg.model.dto.CongViecDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, CongViecID> {

    List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String soCMND, String tenCongViec, String tenCongTy);

    @Query("SELECT NEW com.cg.model.dto.CongViecDTO (" +
                "cv.soCMND, " +
                "ng.tenNganh, " +
                "cv.ngayVaoCongTy, " +
                "cv.tenCongViec, " +
                "cv.tenCongTy, " +
                "cv.diaChiCongTy, " +
                "cv.thoiGianLamViec" +
            ") " +
            "FROM CongViec AS cv " +
            "LEFT JOIN Nganh AS ng " +
            "ON cv.maNganh = ng.maNganh"
    )
    List<CongViecDTO> findAllCongViecDTO();

    @Query("SELECT NEW com.cg.model.dto.CongViecDTO (" +
                "cv.soCMND, " +
                "ng.tenNganh, " +
                "cv.ngayVaoCongTy, " +
                "cv.tenCongViec, " +
                "cv.tenCongTy, " +
                "cv.diaChiCongTy, " +
                "cv.thoiGianLamViec" +
            ") " +
            "FROM CongViec AS cv " +
            "LEFT JOIN Nganh AS ng " +
            "ON cv.maNganh = ng.maNganh " +
            "WHERE cv.soCMND LIKE :keyWord " +
            "OR ng.tenNganh LIKE :keyWord " +
            "OR cv.tenCongViec LIKE :keyWord " +
            "OR cv.tenCongTy LIKE :keyWord"
    )
    List<CongViecDTO> searchAllByKeyword(@Param("keyWord") String keyWord);
}

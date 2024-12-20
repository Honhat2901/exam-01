package com.cg.repository;

import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.TotNghiepListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepID> {

    @Query("SELECT NEW com.cg.model.dto.TotNghiepListDTO (" +
                "tr.tenTruong, " +
                "ng.tenNganh, " +
                "sv.soCMND, " +
                "sv.hoTen, " +
                "tn.heTN, " +
                "tn.ngayTN, " +
                "tn.loaiTN" +
            ") " +
            "FROM TotNghiep AS tn " +
            "JOIN Truong AS tr " +
            "ON tn.maTruong = tr.maTruong " +
            "JOIN Nganh AS ng " +
            "ON ng.maNganh = tn.maNganh " +
            "JOIN SinhVien AS sv " +
            "ON tn.soCMND = sv.soCMND " +
            "WHERE tn.soCMND LIKE :keyWord " +
            "OR sv.hoTen LIKE :keyWord " +
            "OR tn.heTN LIKE :keyWord " +
            "OR tn.loaiTN LIKE :keyWord " +
            "OR ng.tenNganh LIKE :keyWord " +
            "OR tr.tenTruong LIKE :keyWord "
    )
    List<TotNghiepListDTO> searchAllTotNghiepListDTO(@Param("keyWord") String keyWord);

    @Query("SELECT NEW com.cg.model.dto.TotNghiepListDTO (" +
                "tr.tenTruong, " +
                "ng.tenNganh, " +
                "sv.soCMND, " +
                "sv.hoTen, " +
                "tn.heTN, " +
                "tn.ngayTN, " +
                "tn.loaiTN" +
            ") " +
            "FROM TotNghiep AS tn " +
            "JOIN Truong AS tr " +
            "ON tn.maTruong = tr.maTruong " +
            "JOIN Nganh AS ng " +
            "ON ng.maNganh = tn.maNganh " +
            "JOIN SinhVien AS sv " +
            "ON tn.soCMND = sv.soCMND"
    )
    List<TotNghiepListDTO> findAllTotNghiepListDTO();

}

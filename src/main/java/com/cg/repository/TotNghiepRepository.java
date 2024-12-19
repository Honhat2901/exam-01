package com.cg.repository;

import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.Truong;
import com.cg.model.dto.ITotNghiepListDTO;
import com.cg.model.dto.TotNghiepListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepID> {


    @Query(value = "SELECT " +
            "tr.tenTruong, " +
            "ng.tenNganh" +
            "FROM TotNghiep AS tn " +
            "JOIN Truong AS tr " +
            "ON tn.maTruong = tr.maTruong " +
            "JOIN Nganh AS ng " +
            "ON ng.maNganh = tn.maNganh",
            nativeQuery = true
    )
    List<ITotNghiepListDTO> findAllTotNghiepListDTO();

//    @Query(value = "SELECT * FROM vw_get_all_tot_nghiep", nativeQuery = true)
//    List<ITotNghiepListDTO> findAllTotNghiepListDTO();

}
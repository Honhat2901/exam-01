package com.cg.service.totNghiep;

import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.service.IBaseService;

import java.util.List;

public interface ITotNghiepService extends IBaseService<TotNghiep, TotNghiepID> {

    TotNghiep create(SinhVien sinhVien, TotNghiep totNghiep);

    List<TotNghiep> searchTotNghiep();

    List<TotNghiepListDTO> findAllTotNghiepListDTO();

    List<TotNghiepListDTO> searchAllTotNghiepListDTO(String keyWord);

}

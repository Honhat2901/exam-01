package com.cg.service.totNghiep;

import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.service.BaseService;

import java.util.List;

public interface ITotNghiepService extends BaseService<TotNghiep, TotNghiepID> {

    TotNghiep create(SinhVien sinhVien, TotNghiep totNghiep);

    List<TotNghiep> searchTotNghiep();

    List<TotNghiepListDTO> findAllTotNghiepListDTO();

    List<TotNghiepListDTO> searchAllTotNghiepListDTO(String keyWord);

}

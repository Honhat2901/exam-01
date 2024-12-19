package com.cg.service.totNghiep;

import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.ITotNghiepListDTO;
import com.cg.model.dto.TotNghiepCreateDTO;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.service.BaseService;

import java.util.List;

public interface ITotNghiepService extends BaseService<TotNghiep, TotNghiepID> {

    TotNghiep create(SinhVien sinhVien, TotNghiep totNghiep);

    List<TotNghiep> searchTotNghiep();

    List<ITotNghiepListDTO> findAllTotNghiepListDTO();
}

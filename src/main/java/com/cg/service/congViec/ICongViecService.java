package com.cg.service.congViec;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import com.cg.model.dto.CongViecDTO;
import com.cg.service.BaseService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICongViecService extends BaseService<CongViec, CongViecID> {

    List<CongViecDTO> findAllCongViecDTO();

    List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String keyWord);

    List<CongViecDTO> searchAllByKeyword(@Param("keyWord") String keyWord);

}

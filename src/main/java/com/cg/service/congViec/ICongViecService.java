package com.cg.service.congViec;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import com.cg.service.BaseService;

import java.util.List;

public interface ICongViecService extends BaseService<CongViec, CongViecID> {
    List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String keyWord);

}

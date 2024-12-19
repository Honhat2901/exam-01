package com.cg.service.truong;

import com.cg.model.Truong;
import com.cg.service.BaseService;

import java.util.List;

public interface ITruongService extends BaseService<Truong, Long> {

    Truong getById(Long id);
    List<Truong> searchAllByTenTruongLikeOrDiaChiLikeOrSoDTLike(String keySearch);

    List<Truong> searchAllByKeyword(String keyWord);
}

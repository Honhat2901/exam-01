package com.cg.service.congViec;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import com.cg.repository.CongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongViecService implements ICongViecService {

    @Autowired
    private CongViecRepository congViecRepository;

    @Override
    public List<CongViec> findAll() {
        return congViecRepository.findAll();
    }

    @Override
    public Optional<CongViec> findById(CongViecID id) {
        return Optional.empty();
    }

    @Override
    public List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String keyWord) {
        keyWord = "%" + keyWord + "%";
        return congViecRepository.searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(keyWord, keyWord, keyWord);
    }

    @Override
    public CongViec save(CongViec congViec) {
        return congViecRepository.save(congViec);
    }

    @Override
    public CongViec updateById(CongViec congViec, CongViecID id) {
        return null;
    }

    @Override
    public void deleteById(CongViecID id) {

    }
}

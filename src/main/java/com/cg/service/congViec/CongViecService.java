package com.cg.service.congViec;

import com.cg.model.CongViec;
import com.cg.model.CongViecID;
import com.cg.model.dto.CongViecDTO;
import com.cg.repository.CongViecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CongViecService implements ICongViecService {

    private final CongViecRepository congViecRepository;

    @Override
    public List<CongViec> findAll() {
        return congViecRepository.findAll();
    }

    @Override
    public Optional<CongViec> findById(CongViecID id) {
        return Optional.empty();
    }

    @Override
    public List<CongViecDTO> findAllCongViecDTO() {
        return congViecRepository.findAllCongViecDTO();
    }

    @Override
    public List<CongViec> searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(String keyWord) {
        keyWord = "%" + keyWord + "%";
        return congViecRepository.searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(keyWord, keyWord, keyWord);
    }

    @Override
    public List<CongViecDTO> searchAllByKeyword(String keyWord) {
        keyWord = "%" + keyWord + "%";
        return congViecRepository.searchAllByKeyword(keyWord);
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

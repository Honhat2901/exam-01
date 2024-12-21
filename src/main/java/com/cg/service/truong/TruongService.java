package com.cg.service.truong;

import com.cg.model.Truong;
import com.cg.repository.TruongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruongService implements ITruongService {

    private final TruongRepository truongRepository;

    @Override
    public List<Truong> findAll() {
        return truongRepository.findAll();
    }

    @Override
    public Optional<Truong> findById(Long id) {
        return truongRepository.findById(id);
    }

    @Override
    public Truong getById(Long id) {
        return truongRepository.getById(id);
    }

    @Override
    public Truong save(Truong truong) {
        return truongRepository.save(truong);
    }

    @Override
    public List<Truong> searchAllByTenTruongLikeOrDiaChiLikeOrSoDTLike(String keySearch) {
        keySearch = "%" + keySearch + "%";
        return truongRepository.searchAllByTenTruongLikeOrDiaChiLikeOrSoDTLike(keySearch, keySearch, keySearch);
    }


    @Override
    public List<Truong> searchAllByKeyword(String keyWord) {
        return truongRepository.searchAllByKeyword(keyWord);
    }

    @Override
    public Truong updateById(Truong truong, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        truongRepository.deleteById(id);
    }
}

package com.cg.service.sinhvien;

import com.cg.model.SinhVien;
import com.cg.repository.SinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SinhVienService implements ISinhVienService {

    private final SinhVienRepository sinhVienRepository;

    @Override
    public List<SinhVien> findAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public Optional<SinhVien> findById(Long id) {
        return sinhVienRepository.findById(id);
    }

    @Override
    public Boolean existsBySoCMND(String SoCMND) {
        return sinhVienRepository.existsBySoCMND(SoCMND);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return sinhVienRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByEmailAndSoCMNDNot(String email, String soCMND) {
        return sinhVienRepository.existsByEmailAndSoCMNDNot(email, soCMND);
    }

    @Override
    public Optional<SinhVien> findBySoCMND(String soCMND) {
        return sinhVienRepository.findBySoCMND(soCMND);
    }

    @Override
    public List<SinhVien> searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(String keyWord) {
        keyWord = "%" + keyWord + "%";
        return sinhVienRepository.searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(keyWord, keyWord, keyWord, keyWord);
    }

    @Override
    public SinhVien save(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public SinhVien updateById(SinhVien sinhVien, Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}

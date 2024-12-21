package com.cg.service.totNghiep;

import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.repository.SinhVienRepository;
import com.cg.repository.TotNghiepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class TotNghiepService implements ITotNghiepService {

    private final SinhVienRepository sinhVienRepository;

    private final TotNghiepRepository totNghiepRepository;

    @Override
    public List<TotNghiep> findAll() {
        return totNghiepRepository.findAll();
    }

    @Override
    public Optional<TotNghiep> findById(TotNghiepID id) {
        return Optional.empty();
    }

    @Override
    public List<TotNghiepListDTO> findAllTotNghiepListDTO() {
        return totNghiepRepository.findAllTotNghiepListDTO();
    }

    @Override
    public List<TotNghiepListDTO> searchAllTotNghiepListDTO(String keyWord) {
        keyWord = "%" + keyWord + "%";
        return totNghiepRepository.searchAllTotNghiepListDTO(keyWord);
    }

    @Override
    public List<TotNghiep> searchTotNghiep() {
        return null;
    }

    @Override
    public TotNghiep create(SinhVien sinhVien, TotNghiep totNghiep) {
        sinhVienRepository.save(sinhVien);
        totNghiepRepository.save(totNghiep);
        return totNghiep;
    }

    @Override
    public TotNghiep save(TotNghiep totNghiep) {
        return totNghiepRepository.save(totNghiep);
    }

    @Override
    public TotNghiep updateById(TotNghiep totNghiep, TotNghiepID id) {
        return null;
    }

    @Override
    public void deleteById(TotNghiepID id) {

    }
}

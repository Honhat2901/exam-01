package com.cg.service.totNghiep;

import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.TotNghiepID;
import com.cg.model.dto.ITotNghiepListDTO;
import com.cg.repository.SinhVienRepository;
import com.cg.repository.TotNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TotNghiepService implements ITotNghiepService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private TotNghiepRepository totNghiepRepository;

    @Override
    public List<TotNghiep> findAll() {
        return totNghiepRepository.findAll();
    }

    @Override
    public Optional<TotNghiep> findById(TotNghiepID id) {
        return Optional.empty();
    }

    @Override
    public List<ITotNghiepListDTO> findAllTotNghiepListDTO() {
        return totNghiepRepository.findAllTotNghiepListDTO();
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

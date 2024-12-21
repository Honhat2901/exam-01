package com.cg.service.nganh;

import com.cg.model.Nganh;
import com.cg.repository.NganhRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class NganhService implements INganhService {

    private final NganhRepository nganhRepository;

    @Override
    public List<Nganh> findAll() {
        return nganhRepository.findAll();
    }
    @Override
    public Nganh save(Nganh nganh) {
        return nganhRepository.save(nganh);
    }
    @Override
    public Optional<Nganh> findById(Long id) {
        return nganhRepository.findById(id);
    }

    @Override
    public Nganh updateById(Nganh nganh, Long id) {
        nganh.setMaNganh(id);
        return nganhRepository.save(nganh);
    }

    @Override
    public void deleteById(Long id) {
        nganhRepository.deleteById(id);
    }
}


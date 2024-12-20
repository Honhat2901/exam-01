package com.cg.api;

import com.cg.model.SinhVien;
import com.cg.service.sinhvien.ISinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {

    @Autowired
    private ISinhVienService sinhVienService;

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam String k
    ) {
        List<SinhVien> sinhViens = sinhVienService.searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(k);

        return new ResponseEntity<>(sinhViens, HttpStatus.OK);
    }
}

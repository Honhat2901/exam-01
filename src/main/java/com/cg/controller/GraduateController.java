package com.cg.controller;

import com.cg.model.Nganh;
import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.Truong;
import com.cg.model.dto.ITotNghiepListDTO;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.service.nganh.INganhService;
import com.cg.service.sinhvien.ISinhVienService;
import com.cg.service.totNghiep.ITotNghiepService;
import com.cg.service.truong.ITruongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/graduate")
public class GraduateController {

    @Autowired
    private ISinhVienService sinhVienService;

    @Autowired
    private ITruongService truongService;

    @Autowired
    private INganhService nganhService;

    @Autowired
    private ITotNghiepService totNghiepService;


    @GetMapping
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/graduate/index");

        List<TotNghiepListDTO> totNghiepListDTOS = new ArrayList<>();

        List<TotNghiep> totNghieps = totNghiepService.findAll();

//        for (TotNghiep tn : totNghieps) {
//            TotNghiepListDTO totNghiepListDTO = new TotNghiepListDTO();
//
//            Optional<Truong> truong = truongService.findById(tn.getMaTruong());
//            totNghiepListDTO.setTenTruong(truong.get().getTenTruong());
//
//            Optional<Nganh> nganh = nganhService.findById(tn.getMaNganh());
//            totNghiepListDTO.setTenNganh(nganh.get().getTenNganh());
//
//            Optional<SinhVien> sinhVien = sinhVienService.findBySoCMND(tn.getSoCMND());
//
//            totNghiepListDTO.setSoCMND(tn.getSoCMND());
//            totNghiepListDTO.setHoTen(sinhVien.get().getHoTen());
//
//            totNghiepListDTO.setHeTN(tn.getHeTN());
//            totNghiepListDTO.setNgayTN(tn.getNgayTN().toString());
//            totNghiepListDTO.setLoaiTN(tn.getLoaiTN());
//
//            totNghiepListDTOS.add(totNghiepListDTO);
//        }

        mv.addObject("totNghieps", totNghieps);

        return mv;
    }

//    @GetMapping
//    public ModelAndView showList(
//            @RequestParam String s
//    ) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/graduate/index");
//
//        List<TotNghiepListDTO> totNghiepListDTOS = new ArrayList<>();
//
//        List<TotNghiep> totNghieps = totNghiepService.findAll();
//
//    }
}

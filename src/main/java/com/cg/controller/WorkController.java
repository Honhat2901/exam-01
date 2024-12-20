package com.cg.controller;

import com.cg.model.*;
import com.cg.model.dto.CongViecCreateDTO;
import com.cg.service.congViec.ICongViecService;
import com.cg.service.nganh.INganhService;
import com.cg.service.sinhvien.ISinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private ISinhVienService sinhVienService;

    @Autowired
    private INganhService nganhService;

    @Autowired
    private ICongViecService congViecService;


    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/work/index");

        List<CongViec> congViecs = congViecService.findAll();
        mv.addObject("congViecs", congViecs);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/work/create");

        List<Nganh> nganhs = nganhService.findAll();
        mv.addObject("nganhs", nganhs);
        mv.addObject("congViec", new CongViecCreateDTO());

        return mv;
    }

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam String s
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/work/index");

        List<CongViec> congViecs = congViecService.searchAllBySoCMNDLikeOrTenCongViecLikeOrTenCongTyLike(s);

        mv.addObject("congViecs", congViecs);

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @Validated @ModelAttribute CongViecCreateDTO congViecCreateDTO,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/work/create");

        List<Nganh> nganhs = nganhService.findAll();

        mv.addObject("nganhs", nganhs);

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("congViec", congViecCreateDTO);
        }
        else {
            List<String> errors = new ArrayList<>();

            Boolean existsSoCMND = sinhVienService.existsBySoCMND(congViecCreateDTO.getSoCMND());
            if (!existsSoCMND) {
                errors.add("Số CMND của sinh viên không tồn tại");
                mv.addObject("hasError", true);
            }

            Optional<Nganh> nganhOptional = nganhService.findById(congViecCreateDTO.getMaNganh());

            if (nganhOptional.isEmpty()) {
                errors.add("Mã ngành không tồn tại");
            }

            LocalDate ngayVaoCongTy = LocalDate.parse(congViecCreateDTO.getNgayVaoCongTy());

            if (ngayVaoCongTy.isAfter(LocalDate.now())) {
                errors.add("Ngày vào công ty không hợp lệ");
            }
            else {
                int thoiGianLamViec = Integer.parseInt(congViecCreateDTO.getThoiGianLamViec());

                int namLamViec = thoiGianLamViec / 12;
                int thangLamViec = thoiGianLamViec % 12;

                LocalDate ngayLamViec = ngayVaoCongTy.plusYears(namLamViec).plusMonths(thangLamViec);

                if (ngayLamViec.isAfter(LocalDate.now())) {
                    errors.add("Thời gian làm việc không hợp lệ");
                }
            }

            if (errors.isEmpty()) {
                CongViec congViec = new CongViec();
                congViec.setSoCMND(congViecCreateDTO.getSoCMND());
                congViec.setMaNganh(congViecCreateDTO.getMaNganh());
                congViec.setNgayVaoCongTy(ngayVaoCongTy);
                congViec.setTenCongViec(congViecCreateDTO.getTenCongViec());
                congViec.setTenCongTy(congViecCreateDTO.getTenCongTy()  );
                congViec.setDiaChiCongTy(congViecCreateDTO.getDiaChiCongTy());
                congViec.setThoiGianLamViec(Long.parseLong(congViecCreateDTO.getThoiGianLamViec()));

                congViecService.save(congViec);

                mv.addObject("hasSuccess", true);
                mv.addObject("congViec", new CongViecCreateDTO());
            }
            else {
                mv.addObject("hasError", true);
                mv.addObject("dataError", errors);
                mv.addObject("congViec", congViecCreateDTO);
            }
        }

        return mv;
    }
}

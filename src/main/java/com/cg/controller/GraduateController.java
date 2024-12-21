package com.cg.controller;

import com.cg.model.Nganh;
import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.Truong;
import com.cg.model.dto.TotNghiepCreateDTO;
import com.cg.model.dto.TotNghiepListDTO;
import com.cg.service.nganh.INganhService;
import com.cg.service.sinhvien.ISinhVienService;
import com.cg.service.totNghiep.ITotNghiepService;
import com.cg.service.truong.ITruongService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/graduate")
@RequiredArgsConstructor
public class GraduateController {

    private final ISinhVienService sinhVienService;

    private final ITruongService truongService;

    private final INganhService nganhService;

    private final ITotNghiepService totNghiepService;


    @GetMapping
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/graduate/index");

        List<TotNghiepListDTO> totNghiepListDTOS = totNghiepService.findAllTotNghiepListDTO();

        mv.addObject("totNghieps", totNghiepListDTOS);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/graduate/create");

        mv.addObject("totNghiep", new TotNghiepCreateDTO());

        List<Truong> truongs = truongService.findAll();
        List<Nganh> nganhs = nganhService.findAll();

        mv.addObject("truongs", truongs);
        mv.addObject("nganhs", nganhs);

        return mv;
    }

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam String s
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/graduate/index");

        List<TotNghiepListDTO> totNghiepListDTOS = totNghiepService.searchAllTotNghiepListDTO(s);

        mv.addObject("totNghieps", totNghiepListDTOS);

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @Validated @ModelAttribute TotNghiepCreateDTO totNghiepCreateDTO,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/graduate/create");

        List<Truong> truongs = truongService.findAll();
        List<Nganh> nganhs = nganhService.findAll();

        mv.addObject("truongs", truongs);
        mv.addObject("nganhs", nganhs);

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("totNghiep", totNghiepCreateDTO);
        }
        else {
            List<String> errors = new ArrayList<>();

            Boolean existsSoCMND = sinhVienService.existsBySoCMND(totNghiepCreateDTO.getSoCMND());
            if (existsSoCMND) {
                errors.add("Số CMND đã tồn tại");
                mv.addObject("hasError", true);
            }

            Boolean existsEmail = sinhVienService.existsByEmail(totNghiepCreateDTO.getEmail());
            if (existsEmail) {
                errors.add("Email đã tồn tại");
                mv.addObject("hasError", true);
            }

            Optional<Truong> truongOptional = truongService.findById(totNghiepCreateDTO.getMaTruong());

            if (truongOptional.isEmpty()) {
                errors.add("Mã trường không tồn tại");
            }

            Optional<Nganh> nganhOptional = nganhService.findById(totNghiepCreateDTO.getMaNganh());

            if (nganhOptional.isEmpty()) {
                errors.add("Mã ngành không tồn tại");
            }

            LocalDate ngayTN = LocalDate.parse(totNghiepCreateDTO.getNgayTN());

            if (ngayTN.isAfter(LocalDate.now())) {
                errors.add("Ngày tốt nghiệp không hợp lệ");
            }

            if (errors.isEmpty()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setSoCMND(totNghiepCreateDTO.getSoCMND());
                sinhVien.setHoTen(totNghiepCreateDTO.getHoTen());
                sinhVien.setEmail(totNghiepCreateDTO.getEmail());
                sinhVien.setSoDT(totNghiepCreateDTO.getSoDT());
                sinhVien.setDiaChi(totNghiepCreateDTO.getDiaChi());

                TotNghiep totNghiep = new TotNghiep();
                totNghiep.setSoCMND(totNghiepCreateDTO.getSoCMND());
                totNghiep.setMaTruong(truongOptional.get().getMaTruong());
                totNghiep.setMaNganh(nganhOptional.get().getMaNganh());
                totNghiep.setHeTN(totNghiepCreateDTO.getHeTN());
                totNghiep.setNgayTN(ngayTN);
                totNghiep.setLoaiTN(totNghiepCreateDTO.getLoaiTN());

                totNghiepService.create(sinhVien, totNghiep);

                mv.addObject("hasSuccess", true);
                mv.addObject("totNghiep", new TotNghiepCreateDTO());
            }
            else {
                mv.addObject("hasError", true);
                mv.addObject("dataError", errors);
                mv.addObject("totNghiep", totNghiepCreateDTO);
            }
        }

        return mv;
    }

}

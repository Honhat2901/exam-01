package com.cg.controller;

import com.cg.model.Nganh;
import com.cg.model.SinhVien;
import com.cg.model.TotNghiep;
import com.cg.model.Truong;
import com.cg.model.dto.TotNghiepCreateDTO;
import com.cg.service.nganh.INganhService;
import com.cg.service.sinhvien.ISinhVienService;
import com.cg.service.totNghiep.ITotNghiepService;
import com.cg.service.truong.ITruongService;
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
@RequestMapping("/student")
public class StudentController {

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
        mv.setViewName("/student/index");

        List<SinhVien> sinhViens = sinhVienService.findAll();

        mv.addObject("sinhViens", sinhViens);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/create");

        mv.addObject("totNghiep", new TotNghiepCreateDTO());

        List<Truong> truongs = truongService.findAll();
        List<Nganh> nganhs = nganhService.findAll();

        mv.addObject("truongs", truongs);
        mv.addObject("nganhs", nganhs);

        return mv;
    }

    @GetMapping("/edit/{soCMND}")
    public ModelAndView showEditPage(
            @PathVariable String soCMND
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/edit");

        Optional<SinhVien> sinhVienOptional = sinhVienService.findBySoCMND(soCMND);
        if (sinhVienOptional.isEmpty()) {
            mv.addObject("hasError", true);
            mv.addObject("dataError", "Số CMND không tồn tại");
            mv.addObject("sinhVien", null);
        }
        else {
            mv.addObject("sinhVien", sinhVienOptional.get());
        }

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @Validated @ModelAttribute TotNghiepCreateDTO totNghiepCreateDTO,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/create");

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

            if (errors.isEmpty()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setSoCMND(totNghiepCreateDTO.getSoCMND());
                sinhVien.setHoTen(totNghiepCreateDTO.getHoTen());
                sinhVien.setEmail(totNghiepCreateDTO.getEmail());
                sinhVien.setSoDT(totNghiepCreateDTO.getSoDT());
                sinhVien.setDiaChi(totNghiepCreateDTO.getDiaChi());
//                sinhVienService.save(sinhVien);

                LocalDate ngayTN = LocalDate.parse(totNghiepCreateDTO.getNgayTN());

                TotNghiep totNghiep = new TotNghiep();
                totNghiep.setSoCMND(totNghiepCreateDTO.getSoCMND());
                totNghiep.setMaTruong(truongOptional.get().getMaTruong());
                totNghiep.setMaNganh(nganhOptional.get().getMaNganh());
                totNghiep.setHeTN(totNghiepCreateDTO.getHeTN());
                totNghiep.setNgayTN(ngayTN);
                totNghiep.setLoaiTN(totNghiepCreateDTO.getLoaiTN());
//                totNghiepService.save(totNghiep);

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

    @PostMapping("/edit/{soCMND}")
    public ModelAndView update(
            @PathVariable String soCMND,
            @Validated @ModelAttribute SinhVien sinhVien,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/edit");

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("sinhVien", sinhVien);
        }
        else {
            List<String> errors = new ArrayList<>();

            Boolean existsSoCMND = sinhVienService.existsBySoCMND(sinhVien.getSoCMND());
            if (!existsSoCMND) {
                errors.add("Số CMND không tồn tại");
                mv.addObject("hasError", true);
            }
            else {
                Boolean existsEmail = sinhVienService.existsByEmailAndSoCMNDNot(sinhVien.getEmail(), soCMND);
                if (existsEmail) {
                    errors.add("Email đã tồn tại");
                    mv.addObject("hasError", true);
                }

                if (errors.isEmpty()) {
                    sinhVien.setSoCMND(soCMND);
                    sinhVienService.save(sinhVien);
                    mv.addObject("hasSuccess", true);
                    mv.addObject("sinhVien", new SinhVien());
                }
                else {
                    mv.addObject("dataError", errors);
                }
            }
        }

        return mv;
    }
}
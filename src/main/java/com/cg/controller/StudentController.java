package com.cg.controller;

import com.cg.model.SinhVien;
import com.cg.service.sinhvien.ISinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final ISinhVienService sinhVienService;


    @GetMapping
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/index");

        List<SinhVien> sinhViens = sinhVienService.findAll();

        mv.addObject("sinhViens", sinhViens);

        return mv;
    }

    @GetMapping("/edit/{soCMND}")
    public ModelAndView showEditPage(
            @PathVariable String soCMND
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/edit");

        List<String> errors = new ArrayList<>();

        Optional<SinhVien> sinhVienOptional = sinhVienService.findBySoCMND(soCMND);
        if (sinhVienOptional.isEmpty()) {
            errors.add("Số CMND không tồn tại");
            mv.addObject("hasError", true);
            mv.addObject("dataError", errors);
            mv.addObject("sinhVien", null);
        }
        else {
            mv.addObject("sinhVien", sinhVienOptional.get());
        }

        return mv;
    }

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam String s
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/student/index");

        List<SinhVien> sinhViens = sinhVienService.searchAllBySoCMNDLikeOrHoTenLikeOrEmailLikeOrSoDTLike(s);

        mv.addObject("sinhViens", sinhViens);

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
                    mv.addObject("sinhVien", sinhVien);
                }
                else {
                    mv.addObject("dataError", errors);
                }
            }
        }

        return mv;
    }
}

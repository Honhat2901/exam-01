package com.cg.controller;

import com.cg.model.Nganh;
import com.cg.service.nganh.INganhService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final INganhService nganhService;


    @GetMapping
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/job/index");

        List<Nganh> nganhs = nganhService.findAll();

        mv.addObject("nganhs", nganhs);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/job/create");

        mv.addObject("nganh", new Nganh());

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @Validated @ModelAttribute Nganh nganh,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/job/create");

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("nganh", nganh);
        } else {
            nganhService.save(nganh);
            mv.addObject("hasSuccess", true);
            mv.addObject("nganh", new Nganh());
        }

        return mv;
    }

    @GetMapping("/edit/{maNganh}")
    public ModelAndView update(
            @PathVariable Long maNganh
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/job/edit");

        Optional<Nganh> nganhOptional = nganhService.findById(maNganh);

        if (nganhOptional.isPresent()) {
            mv.addObject("nganh", nganhOptional.get());
        }
        else {
            mv.addObject("nganh", null);
        }

        return mv;
    }

    @PostMapping("/edit/{MaNganh}")
    public ModelAndView update(
            @PathVariable Long MaNganh,
            @Validated @ModelAttribute Nganh nganh,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/job/edit");

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("nganh", nganh);
        }
        else {
            nganh.setMaNganh(MaNganh);
            nganhService.save(nganh);
            mv.addObject("hasSuccess", true);
        }

        return mv;
    }
}

package com.cg.controller;

import com.cg.model.Nganh;
import com.cg.model.Truong;
import com.cg.service.truong.ITruongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final ITruongService truongService;


    @GetMapping
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/index");

        List<Truong> truongs = truongService.findAll();

        mv.addObject("truongs", truongs);

        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/create");
        mv.addObject("truong", new Truong());
        return mv;
    }

    @GetMapping("/create2")
    public ModelAndView showCreate2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("create");
        mv.addObject("nganh", new Nganh());
        return mv;
    }

    @GetMapping("/edit/{maTruong}")
    public ModelAndView update(
            @PathVariable Long maTruong
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/edit");

        Optional<Truong> truongOptional = truongService.findById(maTruong);

        if (truongOptional.isPresent()) {
            mv.addObject("truong", truongOptional.get());
        }
        else {
            mv.addObject("truong", null);
        }

        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @Validated @ModelAttribute Truong truong,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/create");

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("truong", truong);
        }
        else {
            truongService.save(truong);
            mv.addObject("hasSuccess", true);
            mv.addObject("truong", new Truong());
        }

        return mv;
    }

    @PostMapping("/edit/{MaTruong}")
    public ModelAndView update(
            @PathVariable Long MaTruong,
            @Validated @ModelAttribute Truong truong,
            BindingResult bindingResult
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/edit");

        if (bindingResult.hasFieldErrors()) {
            mv.addObject("hasError", true);
            mv.addObject("errors", bindingResult.getFieldErrors());
            mv.addObject("truong", truong);
        }
        else {
            truong.setMaTruong(MaTruong);
            truongService.save(truong);
            mv.addObject("hasSuccess", true);
        }

        return mv;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        truongService.deleteById(id);
        return "redirect:/school";
    }

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam String s
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/school/index");

        List<Truong> truongs = truongService.searchAllByTenTruongLikeOrDiaChiLikeOrSoDTLike(s);

        mv.addObject("truongs", truongs);

        return mv;
    }

}

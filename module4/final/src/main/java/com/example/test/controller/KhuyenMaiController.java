package com.example.test.controller;

import com.example.test.model.KhuyenMai;
import com.example.test.service.KhuyenMaiService;
import com.example.test.service.imp.KhuyenMaiServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiService khuyenMaiServiceImp;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name="discount") Optional<Long> discount, @RequestParam(name="start_date") Optional<String> start_date
            ,@RequestParam(name="end_date") Optional<String> end_date, Pageable pageable) {
        List<KhuyenMai> khuyenMaiPage;
        if (discount.isPresent()) {
//            model.addAttribute("khuyenMaiPage", khuyenMaiServiceImp.findAllByMucGiamGiaContaining(discount.get()));
            khuyenMaiPage = khuyenMaiServiceImp.findAllByMucGiamGiaContaining(discount.get());
//            return "/model/view";
//        } else if (start_date.isPresent()) {
//            model.addAttribute("khuyenMaiPage", khuyenMaiServiceImp.findAllByTimeStarContaining(start_date.get()));
//            return "/model/view";
//        } else if (end_date.isPresent()) {
//            model.addAttribute("khuyenMaiPage", khuyenMaiServiceImp.findAllByTimeEndContaining(end_date.get()));
//            return "/model/view";
//        } else if (discount.isPresent() && start_date.isPresent() && end_date.isPresent()) {
//            Long mucgiamgia1 = discount.get();
//            model.addAttribute("khuyenMaiPage", khuyenMaiServiceImp.findAllByMucGiamGiaContainingAndAndTimeStarContainingAndTimeEndContaining(mucgiamgia1, start_date.get(), end_date.get()));
//            return "/model/view";
        } else {
            khuyenMaiPage = khuyenMaiServiceImp.findAll();
        }
            model.addAttribute("khuyenMaiPage", khuyenMaiPage);
            return "/model/view";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("khuyenmai", new KhuyenMai());
        return "model/create";
    }

    //
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("khuyenmai") KhuyenMai khuyenMai, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("khuyenmai", khuyenMai);
            return "/model/create";
        }
        redirectAttributes.addFlashAttribute("message", "save ok");
        khuyenMaiServiceImp.save(khuyenMai);
        return "redirect:/list";
    }

    //
//    @GetMapping("/edit/{id}")
//    public String editForm(@PathVariable("id") Integer id, Model model){
//        Promotion promotion = promotionService.findById(id);
//        model.addAttribute("promotion",promotion);
//        return "edit";
//    }
//
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        khuyenMaiServiceImp.delete(id);
        return "redirect:/list";
    }
}

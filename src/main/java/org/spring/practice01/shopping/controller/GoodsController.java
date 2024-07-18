package org.spring.practice01.shopping.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.spring.practice01.shopping.model.CategoryDTO;
import org.spring.practice01.shopping.model.GoodsDTO;
import org.spring.practice01.shopping.model.ReplyDTO;
import org.spring.practice01.shopping.model.UserDTO;
import org.spring.practice01.shopping.service.CategoryService;
import org.spring.practice01.shopping.service.GoodsService;
import org.spring.practice01.shopping.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product/")
@RequiredArgsConstructor
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
//    @Autowired
//    private CategoryService categoryService;
    @Autowired
    private ReplyService replyService;

    @GetMapping("showAll")
    public String showAll(HttpSession session, Model model,RedirectAttributes redirectAttributes){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }
        List<GoodsDTO> goodslist = goodsService.pickAll();
        model.addAttribute("goodslist",goodslist);

        return("product/showAll");
    }

    @GetMapping("showOne/{goodsNo}")
    public String showOnegood(HttpSession session, Model model, @PathVariable int goodsNo, RedirectAttributes redirectAttributes){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if (logIn == null) {
            return "redirect:/";
        }
        GoodsDTO goodsDTO = goodsService.pickOne(goodsNo);
        if(goodsDTO == null){
            System.out.println("goodsDTO is null");
            redirectAttributes.addFlashAttribute("message","유효x");
            return "redirect:/showMessage";
        }
        List<ReplyDTO> replylist= replyService.showAll(goodsNo);
        model.addAttribute("goodsDTO",goodsDTO);
        if(replylist !=null){
            model.addAttribute("replylist",replylist);
        }
        return "/product/showOne";
    }
}

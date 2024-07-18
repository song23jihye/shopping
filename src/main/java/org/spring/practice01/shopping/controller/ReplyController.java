package org.spring.practice01.shopping.controller;

import jakarta.servlet.http.HttpSession;
import org.spring.practice01.shopping.model.ReplyDTO;
import org.spring.practice01.shopping.model.UserDTO;
import org.spring.practice01.shopping.service.GoodsService;
import org.spring.practice01.shopping.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/insert/{goodsId}")
    public String insert(ReplyDTO replyDTO, HttpSession session, @PathVariable int goodsId, RedirectAttributes redirectAttributes){
        UserDTO logIn = (UserDTO) session.getAttribute("logIn");
        if(logIn == null){
            return "redirect:/";
        }
        if(goodsService.pickOne(goodsId) == null){
            redirectAttributes.addFlashAttribute("message", "유효하지 않은 글 번호입니다.");
            return "redirect:/showMessage";
        }
        replyDTO.setGoodsId(goodsId);
        replyDTO.setWriterId(logIn.getId());
        replyDTO.setWriterNickname(logIn.getNickname());
        replyService.insert(replyDTO);
        return "redirect:/product/showOne/"+goodsId;
    }
//    @GetMapping("")
//    public String {
//
//    }

}

package org.spring.practice01.shopping.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.spring.practice01.shopping.model.BasketDTO;
import org.spring.practice01.shopping.model.GoodsDTO;
import org.spring.practice01.shopping.model.UserDTO;
import org.spring.practice01.shopping.service.BasketService;
import org.spring.practice01.shopping.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basket/")
@RequiredArgsConstructor
public class BasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private GoodsService goodsService;
    @GetMapping("showBasket/{id}")
    public String showBasket(HttpSession session,Model model, @PathVariable int id){
//        System.out.println("장바구니 조회한 고객 id : "+id)
        List<BasketDTO> goodsInBasket= basketService.pickOneBasket(id);
        if(goodsInBasket == null){
            System.out.println("basket is null");
            model.addAttribute("goodsInBasket",0);
        }
        model.addAttribute("goodsInBasket",goodsInBasket);
        return "user/showbasket";
    }
    @GetMapping("putItem/{goodsid}") //goodsId
    public String putItem(HttpSession session,Model model, @PathVariable int goodsid){
        UserDTO user = (UserDTO)session.getAttribute("logIn");
        int customerNum= user.getId();

        GoodsDTO goodsPut = goodsService.pickOne(goodsid);
        int goodPutId = goodsPut.getId();
        //위 둘을 hashmap으로 엮어서 xml parameterType hashmap으로
        //VS DTO 따로 만들기 VS inner join

        List<Integer> whatsinmyBasket = basketService.goodsInMyBasket(customerNum);

        if(!whatsinmyBasket.contains(goodsid)){
            Map<String, Object> param = new HashMap<>();
            param.put("customerNum",customerNum); //key,value
            param.put("goodsPutDTO",goodsPut);
            basketService.insertNew(param);
        }else{
            Map<String, Object> param = new HashMap<>();
            param.put("customerNum",customerNum); //key,value
            param.put("goodPutId",goodPutId);
            basketService.insertOld(param);
        }
//        return "product/showOne/"+goodPutId;
        return "redirect:/product/showAll";//id가 없어서 목록이 안뜨지
    }
}
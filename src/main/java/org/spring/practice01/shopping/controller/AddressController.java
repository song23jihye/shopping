package org.spring.practice01.shopping.controller;

import jakarta.servlet.http.HttpSession;
import org.spring.practice01.shopping.model.AddressDTO;
import org.spring.practice01.shopping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{id}")
    public String addressManages(HttpSession session, Model model,@PathVariable int id){//id = logIn.id
        List<AddressDTO> addressList = addressService.pickOneAddress(id);
        if(!addressList.isEmpty()){
//            for(AddressDTO a : addressList){
//                System.out.println(a.toString());
//            }
            model.addAttribute("addressList",addressList);
        }else{
            System.out.println("주소지 목록이 비었습니다.");
        }
        return "user/address";
    }
    @PostMapping("/address/newAddress/{id}")
    public String addNewAddress(HttpSession session,Model model, @PathVariable int id){

        System.out.println(id+"번 고객님 - 배송지 추가 try");
        return("redirect:/product/showAll");
    }
}

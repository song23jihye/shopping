package org.spring.practice01.shopping.controller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.spring.practice01.shopping.model.UserDTO;
import org.spring.practice01.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth")
    public String auth(UserDTO userDTO, HttpSession session){
        UserDTO login = userService.auth(userDTO);
        if(login == null){
            System.out.println("auth: login is null");
            return "redirect:/";
        }
        session.setAttribute("logIn",login);
        return "redirect:/product/showAll";
    }
    @GetMapping("/mypage/{id}") //setAttibute("logIn")
    public String mypage(HttpSession session, @PathVariable int id){
        UserDTO logIn = (UserDTO)session.getAttribute("logIn");

        return "user/mypage";
    }
    @GetMapping("/register")
    public String showRegister(){
        return "user/register";
    }
    @PostMapping("/register")
    public String register(UserDTO userDTO, HttpSession session){
        userService.register(userDTO);
        return "redirect:/";
    }
//    @PostMapping("register")
//    public String register(UserDTO userDTO, RedirectAttributes redirectAttributes, HttpSession session){
//        UserDTO logIn = (UserDTO)session.getAttribute("logIn");
//        System.out.println("logIn :" + session.getAttribute("logIn").toString());
//        userService.register(userDTO);
//        if (userService.validateUsername(userDTO.getUsername())) {
////            userDTO.setPassword(encoder.encode(userDTO.getPassword()));
//            userService.register(userDTO);
//        } else {
//            redirectAttributes.addFlashAttribute("message", "중복된 아이디로는 가입하실 수 없습니다.");
//            return "redirect:/showMessage";
//        }
//        return "redirect:/";
//    }

}

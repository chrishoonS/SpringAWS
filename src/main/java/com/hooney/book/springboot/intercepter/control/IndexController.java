package com.hooney.book.springboot.intercepter.control;

import com.hooney.book.springboot.intercepter.User;
import com.hooney.book.springboot.intercepter.config.MySecured;
import com.hooney.book.springboot.intercepter.testEnum.Role;
import com.hooney.book.springboot.intercepter.testRepo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class IndexController {
    private final UserRepo userRepo;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("user") != null){
            User user = (User) httpSession.getAttribute("user");
            model.addAttribute("user",user);
            return "redirect:my-info";
        }
        return "login-form";
    }

    @PostMapping("login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession httpSession) {
        if(!userRepo.isUser(email, password)){
            return "redirect:login";
        }
        return "redirect:/index";
    }

    @MySecured(role = Role.USER)
    @GetMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index";
    }

    @GetMapping("my-info")
    public String myInfo(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user") != null){
            User user = (User) httpSession.getAttribute("user");
            model.addAttribute("user", user);
        }else{
            model.addAttribute("user", new User());
        }
        return "my-info";
    }
}

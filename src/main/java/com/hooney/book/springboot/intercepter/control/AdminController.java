package com.hooney.book.springboot.intercepter.control;

import com.hooney.book.springboot.intercepter.config.MySecured;
import com.hooney.book.springboot.intercepter.testEnum.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @MySecured(role = Role.ADMIN)
    @GetMapping
    public String admin(){
        return "admin page";
    }
}

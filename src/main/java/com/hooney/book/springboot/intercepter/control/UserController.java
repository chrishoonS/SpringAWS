package com.hooney.book.springboot.intercepter.control;

import com.hooney.book.springboot.intercepter.config.MySecured;
import com.hooney.book.springboot.intercepter.testEnum.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @MySecured(role = Role.USER)
    @GetMapping
    public String user(){
        return "user page";
    }
}

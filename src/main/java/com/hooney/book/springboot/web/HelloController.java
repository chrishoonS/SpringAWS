package com.hooney.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 생성(=메소드마다 @ResponseBody 선언)
public class HelloController {
    @GetMapping("/hello")   //GET 요청을 받는 API로 생성
    public String hello() {
        return "hello";
    }
}

package com.hooney.book.springboot.web;

import com.hooney.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 생성(=메소드마다 @ResponseBody 선언)
public class HelloController {
    @GetMapping("/hello")   //GET 요청을 받는 API로 생성
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")   //GET 요청을 받는 API로 생성
    public HelloResponseDto helloDto(@RequestParam("name") String name,     //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

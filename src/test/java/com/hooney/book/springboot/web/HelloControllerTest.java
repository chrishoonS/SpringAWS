package com.hooney.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)                        //테스트 실행시 JUnit과 스프링부트 테스트 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)    //Web(Spring MVC)에 집중 가능한 어노테이션(컨트롤러만 사용시에만 사용)
public class HelloControllerTest {
    @Autowired                                      //spring이 관리하는 Bean 주입 받음
    private MockMvc mvc;                            //Web API 테스트시 사용, mvc테스트의 시작점

    @Test
    public void helloReturn() throws Exception{
        String hi = "hello";
        mvc.perform(get("/hello"))         //MockMvc를 통해 HTTP GET요청
                .andExpect(status().isOk())          //HTTP header의 status 결과 검증
                .andExpect(content().string(hi));    //응답 본문의 내용 검증
    }

}

package com.hooney.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void helloDtoReturn() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)                                 //API테스트 시 사용될 요청 파라미터 설정(String만 허용)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        //jsonPath : JSON 응답값을 필드별로 검증, $기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)))
        ;
    }

}

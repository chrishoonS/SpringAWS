package com.hooney.book.springboot.intercepter.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * interceptor 등록을 위한 config 파일
 * @Component로 Bean으로 등록된 Interceptor를 가져와 registry에 등록
 **/
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final HandlerInterceptor authInterceptor;

    //@Override <- 왜에러나지?...
    public void addIntercptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**") //interceptor를 적용할 pattern
                .excludePathPatterns(); //제외할 패턴
    }
}




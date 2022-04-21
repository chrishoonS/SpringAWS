package com.hooney.book.springboot.web;

import com.hooney.book.springboot.web.testEnum.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.hooney.book.springboot.web.testRepo.UserRepo;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitData {
    private final UserRepo userRepo;

    // https://hyeonic.tistory.com/201 <- 나중에 이 페이지 설명 참고할 것

    @PostConstruct
    public void init(){
        User admin = new User("admin@email.com", "1234","관리자");
        admin.setRole(Role.ADMIN);
        userRepo.save(admin);

        User sjh = new User("sjh@email.com", "1234","sjh");
        sjh.setRole(Role.USER);
        userRepo.save(sjh);

        List<User> users = userRepo.findAll();
        for(User user : users){
            log.info(user.toString());
        }
    }
}

package com.hooney.book.springboot.web.testRepo;

import com.hooney.book.springboot.web.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepo {
    private static Map<Long, User> userMap = new HashMap<>();   //DB운영이 따로 없으므로 @Repository로 인하여 Spring에서 bean으로 자동 관리 해줌
    private static long count = 1L;

    private UserRepo(){}

    public Long save(User user){
        user.setId(count);
        userMap.put(count, user);
        count ++;

        return user.getId();
    }

    public Boolean isUser(String email, String password){
        return userMap.values().stream()
                .anyMatch((user -> user.getEmail().equals(email) && user.getPassword().equals(password)));
    }

    public User findByEmail(String email){
        for(User user : userMap.values()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public List<User> findAll(){
        return new ArrayList<>(userMap.values());
    }
}

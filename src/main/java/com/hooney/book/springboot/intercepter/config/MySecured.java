package com.hooney.book.springboot.intercepter.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.hooney.book.springboot.intercepter.testEnum.Role;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MySecured {
    Role role() default Role.USER;
}

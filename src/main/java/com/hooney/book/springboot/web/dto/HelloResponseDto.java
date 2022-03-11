package com.hooney.book.springboot.web.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor                    //선언된 final필드가 포함된 생성자 생성, final 없으면 생성자 포함X
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

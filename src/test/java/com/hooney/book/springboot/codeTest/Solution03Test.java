package com.hooney.book.springboot.codeTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution03Test {

    Solution03 slt03 = new Solution03();
    @Test
    void test() {
        assertEquals(slt03.solution(45),7);
        assertEquals(slt03.solution(125), 229);
    }
}
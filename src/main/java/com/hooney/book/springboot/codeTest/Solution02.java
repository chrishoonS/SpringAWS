package com.hooney.book.springboot.codeTest;

public class Solution02 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int temp = 0;
        for(int i=0; i < a.length; i++){
            temp = a[i]*b[i];
            answer += temp;
        }

        return answer;
    }
}

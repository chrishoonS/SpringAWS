package com.hooney.book.springboot.codeTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //문제2
//    public static int solution(int[] numbers) {
//        int answer = 0;
//        numbers = new int[]{1,2,3,4,5};
//        if(numbers.length <= 10){
//            for(int i=0; i < numbers.length; i++){
//                answer += numbers[i];
//            }
//        }else {
//            System.out.println("길이초과");
//        }
//        answer = 45 - answer;
//        return answer;
//    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> totList = new ArrayList<>();  //합계 저장하는 배열
        Arrays.sort(numbers);
        for(int i=0; i < numbers.length; i++){
            for(int j=1+i; j < numbers.length; j++){
                int tmp = numbers[i] + numbers[j]; //n번째 + n+1번째 tmp 변수에 저장
                if(totList.indexOf(tmp) < 0){      //indexOf 함수는 특정 문자열에서 해당 문자 인덱스 값 반환하고 찾지 못할때 -1 반환
                    totList.add(tmp);
                }
            }
        }

        answer = new int[totList.size()];

        int no = 0;
        for(int num : totList){
            answer[no++] = num;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] result = {};
        result = solution(new int[]{2,1,3,4,1});
        System.out.println(Arrays.toString(result));
    }
}

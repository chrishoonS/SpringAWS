package com.hooney.book.springboot.codeTest;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rambda2 {

    //람다식 공부
    //람다식 : 식별자 없이 실행가능한 함수
    //(매개변수, ...) -> {실행문}
    public static void exec(Compare com) {
        int k = 10;
        int m = 20;
        int value = com.compareTo(k,m);
        System.out.println(value);
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(9));
//        exec((i,j)->{
//            System.out.println("exec i :::::::::" + i);
//            System.out.println("exec j :::::::::" + j);
//            return i+j;
//        });

        //오늘 날짜
        LocalDate today = LocalDate.now();
        System.out.println(today);

        //특정 날짜 사이의 연/월/일 차이
        LocalDate targetDate1 = LocalDate.of(1990,11,3);
        System.out.println(today.until(targetDate1));

        //특정 날짜 사이의 차이를 일 수로
        long d1 = ChronoUnit.DAYS.between(today, targetDate1);
        long d2 = ChronoUnit.DAYS.between(today, LocalDate.of(2022, 8, 3));
        System.out.println(d1);
        System.out.println(d2);

        //특정 날짜의 100일 전/후
        System.out.println(ChronoUnit.DAYS.addTo(today, -100));
        System.out.println(ChronoUnit.DAYS.addTo(today, 100));


    }

}

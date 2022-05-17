package com.hooney.book.springboot.codeTest;

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
        int b1 = 0B0010; // 0B -> 2진수 리터럴
        int b2 = 0B0101;
        int b3 = 0B1111;
        int rtAndOp = b1 & b3; // 비트 AND 연산자
        int rtOrOp = b1 | b2; // 비트 OR 연산자
        int rtXorOp = b1 ^ b3; // 비트 XOR 연산자
        System.out.println("b1 AND b3 : " + Integer.toBinaryString(rtAndOp)); // 0010
        System.out.println("b1 OR b2 : " + Integer.toBinaryString(rtOrOp)); // 0111
        System.out.println("b1 XOR b3 : " + Integer.toBinaryString(rtXorOp)); // 1101
        System.out.println(Integer.toBinaryString(9));
//        exec((i,j)->{
//            System.out.println("exec i :::::::::" + i);
//            System.out.println("exec j :::::::::" + j);
//            return i+j;
//        });
    }

}

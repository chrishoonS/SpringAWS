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
        exec((i,j)->{
            System.out.println("exec i :::::::::" + i);
            System.out.println("exec j :::::::::" + j);
            return i+j;
        });
    }

}

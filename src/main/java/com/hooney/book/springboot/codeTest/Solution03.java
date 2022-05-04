package com.hooney.book.springboot.codeTest;

public class Solution03 {
    public int solution(int n) {
        int answer = 0;
        String org = "";
        String chg = "";
        while(n > 0){
            org = (n%3) + org;
            n /= 3;
        }
        //org = 1200
//        System.out.println(org);
        for (int i=0; i<org.length(); i++){
            chg = org.substring(i, i+1) + chg;
        }
//        System.out.println("chg value----"+chg);//chg = 0021
        for (int j=0; j<chg.length(); j++){
            int tmp =0;
            tmp = Integer.parseInt(chg.substring(j, j+1));
            answer += tmp * (int) Math.pow(Double.parseDouble("3"), Double.parseDouble(String.valueOf(chg.length()-j-1)));
        }
        System.out.println(answer);

        return answer;
    }
}

package com.hooney.book.springboot.codeTest;

public class Main {
    static int N=4;
    static int Nums[] = {1,2,3,4};

    public static void main(String[] args) {
        System.out.println("순열-가장 큰 두 자리 = " + solve1(0,0,0));
        System.out.println("조합-가장 큰 두 수의 합 = " + solve2(0,0,0));
    }

    private static int solve1(int cnt, int used, int val) {
        if (cnt == 2) return val;

        int ret = 0;
        for (int i = 0; i < N; i++) {
            if((used & 1 << i) != 0) continue;
            ret = Math.max(ret, solve1(cnt+1, used|1 << i, val+10+Nums[i]));
        }
        return ret;
    }

    private static int solve2(int pos, int cnt, int val) {
        if (pos == 2) return val;
        if (pos == N) return -1;

        int ret = 0;
        ret = Math.max(pos, solve2(pos+1, cnt+1, val+Nums[pos]));
        ret = Math.max(pos, solve2(pos+1, cnt, val));
        return ret;
    }
}

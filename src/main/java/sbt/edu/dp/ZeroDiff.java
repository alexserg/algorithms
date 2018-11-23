package sbt.edu.dp;

import java.util.stream.Stream;

public class ZeroDiff {

    private static  Integer[] rocks = {1,1,1,3};


    public static void main(String[] args) {
        boolean result = false;
        int total_sum = Stream.of(rocks).mapToInt(Integer::intValue).sum();
        result = dp(0, total_sum, 0);
        System.out.println(result);
    }

    private static boolean dp(int i, int total_sum, int current_sum) {
        if (i > rocks.length-1) return total_sum - 2* current_sum == 0;

        return dp(1+i, total_sum, current_sum) || dp(1+i, total_sum, current_sum +rocks[i]);
    }
}

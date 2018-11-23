package sbt.edu.dp;

import java.util.stream.Stream;

public class GivenSum {


    private static  Integer[] rocks = {1,3,7,12,5};
    private static int givenSum =2;

    public static void main(String[] args) {
        boolean result = false;
        int total_sum = Stream.of(rocks).mapToInt(Integer::intValue).sum();
        result = dp(0, 0);
        System.out.println(result);

    }
    private static boolean dp(int i, int current_sum) {
        if (i > rocks.length-1) return current_sum == givenSum;
        if(current_sum == givenSum) return true;

        return  dp(1+i, current_sum)||dp(1+i, current_sum +rocks[i]);
    }
}

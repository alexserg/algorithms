package sbt.edu.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MinimalDiff {

   private static  Integer[] rocks = {1,-1,-1};

   public static void main(String[] args) {

       int total_sum = Stream.of(rocks).mapToInt(Integer::intValue).sum();
       int sum = 0;
       sum = dp(0, total_sum, sum);
       System.out.println(total_sum - 2*sum);

   }
    private static int dp(int i, int total_sum, int current_sum) {
        if (i > rocks.length-1) return current_sum;

        int resultWithout =  dp(1+i, total_sum, current_sum); //sum if current rock is excluded
        int resultWith =  dp(1+i, total_sum, current_sum +rocks[i]);//sum if current rock is included

        if (Math.abs(total_sum - 2*resultWithout) <= Math.abs(total_sum - 2*resultWith )) { //check which will get smaller difference
            return resultWithout;
        }
        return resultWith;
    }
}

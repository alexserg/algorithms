package sbt.edu.dp;

public class MaxSumSubarray {

    private static  Integer[] array = {-30,-10};

    public static void main(String[] args) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxSum = Math.max(dp(i, array[i]), maxSum);
        }
        System.out.println(maxSum);

    }
    private static int dp(int i, int sum) {
        if (i == array.length-1) return sum;
        return Math.max(sum,  dp(1+i,  sum+array[i]));
    }
}

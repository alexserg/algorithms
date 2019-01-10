import java.util.*;

public class Recursion {

    static void sum(int[] arr, int i, int sum, int target, String s)
    {
        for(int j = i + 1; j < arr.length; j++){
            if(sum + arr[j] == target){
                System.out.println(s + " " + String.valueOf(arr[j]));
            }else{
                sum(arr, j, sum+arr[j], target, s+" "+String.valueOf(arr[j]));
            }
        }
    }

    public static void main(String[] args)
    {
        int[] numbers = {6,3,8,10,1};//на примере этих чисел
        for(int i =0; i < numbers.length; i++){
            sum(numbers, i, numbers[i], 11, String.valueOf(numbers[i]));// на числе 11
        }

    }
}
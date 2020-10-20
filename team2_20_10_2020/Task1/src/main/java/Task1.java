import javafx.util.Pair;

import java.util.Scanner;

/**
 *Задача1
 * Вам дан массив, отсортированный в порядке возрастания и число.
 * Найти индексы первого и последнего вхождения числа в массив.
 * Вход: array = [5,7,7,8,8,10], target = 8
 * Выход: [3,4]
 */
public class Task1 {
    /**
     * Решение:
     * Находим левую и правую границу бинпоисками(binPoiskL,binPoiskR) соответственно.
     * В случае если элемента не было в массиве выводим -1 -1
     */
    private static int[] initialise(){
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        int n = firstLine.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = Integer.parseInt(firstLine[i]);
        }
        return array;
    }

    private static int binPoiskL(int[] array, int target){
        int l = -1;
        int r = array.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (array[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (r == array.length){
            return -1;
        }
        return r;
    }
    private static int binPoiskR(int[] array, int target){
        int l = 0;
        int r = array.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (array[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (r == array.length) {
            r--;
            return r;
        }
        if (array[r]!= target){
            r--;
        }
        return r;
    }

    public static Pair<Integer,Integer> solution(int[] array , int target) {
        int l = binPoiskL(array, target);
        int r = binPoiskR(array, target);
        if (l == -1){
            return new Pair<>(-1,-1);
        }
        return new Pair<>(l,r);
    }

    public static void main(String[] args) {
        int[] array = initialise();
        int target = 8;
        System.out.println(solution(array,target).getKey() + " " + solution(array,target).getValue());
    }
}

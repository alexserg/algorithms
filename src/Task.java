/*
    1. Разбиваем на два множества, найти минимальную разницу
    2. Выяснить, мижно ли добиться нулевой разницы
    3. Выяснить, мижно ли добиться разницы, равной какому-то числу
    4. Макс сумма подпоследовательности
 */

import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
        int[] list = {5, 1, 1, 1, 1};
        int heap1 = IntStream.of(list).sum();
        int heap2 = 0;
        System.out.println(solve1(heap1, heap2, 0, list));
        System.out.println(solve2(heap1, heap2, 0, list));
        System.out.println(solve3(heap2, 0, list, 10));
        System.out.println(solve4(list));
    }

    public static int solve1(int heap1, int heap2, int index, int[] list) {
        if (index == list.length - 1) {
            return Math.abs(heap1 - heap2 - heap2);
        } else {
            return (Math.min(solve1(heap1, heap2 + list[index], index + 1, list),
                    solve1(heap1, heap2, index + 1, list)));
        }
    }

    public static boolean solve2(int heap1, int heap2, int index, int[] list) {
        if (index == list.length - 1) {
            return Math.abs(heap1 - heap2 - heap2) == 0;
        } else {
            return ((solve2(heap1, heap2 + list[index], index + 1, list) ||
                    solve2(heap1, heap2, index + 1, list)));
        }
    }

    public static boolean solve3(int heap2, int index, int[] list, int Num) {
        if (index == list.length - 1) {
            return heap2 == Num;
        } else {
            return ((solve3(heap2 + list[index], index + 1, list, Num) ||
                    solve3(heap2, index + 1, list, Num)));
        }
    }

    public static int solve4(int[] list) {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < list.length; i++) {
            sum = sum + list[i];
            if (sum < 0) {sum = 0;}
            if (sum > max) { max = sum; }
        }
        return max;
    }


    /*
    //пытался решить с помощью динамического программирования
    public static int solve4(int index_beg, int index_end, int[] list) {
        if (index_beg>index_end) {
            return -1;
        }
        if ((index_beg == list.length -1)&&(index_beg == list.length -1)) {
            return list[index_beg];
        }
        if ((index_beg >= list.length)||(index_beg >= list.length)) {
            return -1;
        }
        return Math.max(
                solve4(index_beg,index_end +1, list),
                solve4(index_beg + 1,index_end,list)
        );
    }

    public static int calc_subseq(int index_beg, int index_end, int [] list) {
        int sum = 0;
        for (int i = index_beg; i <= index_end; i++) {
            sum = sum + list[i];
        }
        return sum;
    }
*/
}


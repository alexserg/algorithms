import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DivideArrayForMinDiff {

    private static int sum(List<Integer> arr) {

        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            total += arr.get(i);
        }

        return total;
    }

    private static int diff(ArrayList<Integer> arr, ArrayList<Integer> arr2) {
        int diff = sum(arr) - sum(arr2);
        if (diff < 0)
            diff = diff * -1;
        return diff;
    }

    private static int MIN = Integer.MAX_VALUE;

    private static int binarySearch(int low, int high, ArrayList<Integer> arr1, int arr2sum) {

        if (low > high || low < 0)
            return -1;

        int mid = (low + high) / 2;
        int midVal = arr1.get(mid);

        int sum1 = sum(arr1);
        int resultOfMoveOrg = (sum1 - midVal) - (arr2sum + midVal);
        int resultOfMove = (sum1 - midVal) - (arr2sum + midVal);
        if (resultOfMove < 0)
            resultOfMove = resultOfMove * -1;

        if (resultOfMove < MIN) {

            return mid;
        }

        if (resultOfMoveOrg < 0) {

            return binarySearch(low, mid - 1, arr1, arr2sum);
        } else {


            return binarySearch(mid + 1, high, arr1, arr2sum);
        }
    }

    private static int findMin(ArrayList<Integer> arr1) {

        ArrayList<Integer> list2 = new ArrayList<>(arr1.subList(arr1.size() - 1, arr1.size()));
        arr1.remove(arr1.size() - 1);
        while (true) {

            int index = binarySearch(0, arr1.size(), arr1, sum(list2));
            if (index != -1) {
                int val = arr1.get(index);
                arr1.remove(index);
                list2.add(val);
                Collections.sort(list2);
                MIN = diff(arr1, list2);
            } else {

                int index2 = binarySearch(0, list2.size(), list2, sum(arr1));
                if (index2 != -1) {

                    int val = list2.get(index2);
                    list2.remove(index2);
                    arr1.add(val);
                    Collections.sort(arr1);

                    MIN = diff(arr1, list2);
                } else {

                    break;
                }
            }
        }

        System.out.println("MIN==>" + MIN);
        System.out.println("arr1==>" + arr1 + ":" + sum(arr1));
        System.out.println("list2==>" + list2 + ":" + sum(list2));
        return 0;
    }

    public static void main(String args[]) {

        ArrayList<Integer> org = new ArrayList<>();
        org = new ArrayList<>();
        org.add(1);
        org.add(2);
        org.add(3);
        org.add(7);
        org.add(8);
        org.add(10);

        findMin(org);
    }
}
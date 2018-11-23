import java.util.Scanner;
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for(int j = n; j > 0; j--)
        {
            for(int i = 0; i < n-1;i++)
            {
                if(array[i+1] > array[i])
                {
                    int r = array[i];
                    array[i] = array[i+1];
                    array[i+1] = r;
                }
            }}
        for (int i = 0; i < n; i++)
        {
            System.out.print(array[i] + " ");
        }

       int[] ms1 = new int[n/2];
        int[] ms2 = new int[n/2];
        for (int i = 0; i < n/ 2; i++)
        {
            ms1[i] = array[i];
            ms2[i] = array[i+n/2];

        }
        System.out.println();
        for (int i = 0; i < n/2; i++)
        {
            System.out.print(ms1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n/2; i++)
        {
            System.out.print(ms2[i] + " ");
        }

    }
}
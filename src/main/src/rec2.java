import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class rec2
{
    public static int maxSubArraySum(int a[], int size)
    {
        int s[] = new int[size+2];

        //they will form your base cases
        s[0] = 0;
        s[1] = a[0];
        s[2] = a[0] + a[1];

        for(int i = 2; i < size; i++)
        {
            s[i+1] = Math.max(a[i] + s[i-1], a[i] + a[i-1] + s[i-2]);
            s[i+1] = Math.max(s[i+1], s[i]);
        }
        return s[size];
    }

    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int a[]=new int[size];
        for(int i=0;i<size;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(maxSubArraySum(a, a.length));
    }
}
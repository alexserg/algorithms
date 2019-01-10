/**
 * Created by user on 23.11.2018.
 */
import java.util.Scanner;
public class Solution1 {
  public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
        {
            array[i] = scanner.nextInt();
        }
        int max = array[0];
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
        int sum = 0;
        int psum = 0;
      for(int i=0;i < n; i++) {
          sum += array[i];
      }
      psum=sum/2;
      System.out.println("sum  = " + sum);
      System.out.println("psum = " + psum);//посчитали
        int rez = 0;
        int[] arr = new int[n/2];
        int count = 0;
      for(int i=0; i < n;++i) {
          if( rez+ array[i] <= psum) {
              rez += array[i];
              arr[count] = array[i];
              count++;
              System.out.print("include " + array[i]);//добавим в кучу
          }
      }
      System.out.println();
        for (int i = 0; i < n; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
      for (int i = 0; i < count; i++)
      {
          System.out.print(arr[i] + " ");
      }



  }

}

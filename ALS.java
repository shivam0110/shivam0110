import java.io.*;
class ALS
{
      static int num_line = 2;
      static int num_station = 15;
      static int min(int a, int b)
      {
            return a < b ? a : b;
      }
      static int assmebly(int a[][], int t[][], int e[], int x[])
      {
            int T1[]= new int [num_station];
            int T2[] =new int[num_station];
            T1[0] = e[0] + a[0][0];
            T2[0] = e[1] + a[1][0];
            for (int i = 1; i < num_station; ++i)
            {
                  T1[i] = min(T1[i - 1] + a[0][i],T2[i - 1] + t[1][i] + a[0][i]); 
                  T2[i] = min(T2[i - 1] + a[1][i],T1[i - 1] + t[0][i] + a[1][i]); 
            }
            return min(T1[num_station-1] + x[0],T2[num_station-1] + x[1]); 
      }
      public static void main (String[] args)
      {
            int a[][] = {{7,5,6,10,6,7,8,9,6,10,13,14,7,9,10},{12,11,13,15,8,9,7,6,5,12,11,14,7,9,13}}; 
            int t[][] = {{9,7,14,8,7,9,8,11,10,12,13,5,15,7,8},{7,9,12,10,12,13,14,15,8,9,7,6,5,10,12}};
            int e[] = {10, 12}, x[] = {12, 6};
            System.out.println(assmebly(a, t, e, x));
      } 
} 
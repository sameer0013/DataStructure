import java.io.*;
import java.util.*;

public class StateOfWakanda2 
 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[][] a= new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int dlength=n;
        for(int c=0;c<n;c++){
            int d1=0;
            int d2=c;
            int d=0;
            while(d<dlength){
                System.out.println(a[d1][d2]);
                d1++;
                d2++;
                d++;

            }
            dlength -=1;

        }
    }

}

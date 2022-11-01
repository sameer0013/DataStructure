import java.io.*;
import java.util.*;

public class SubArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        subArray(a);

    }

    public static void subArray(int[] a) {

        // first we place i in 0th position
        for (int i = 0; i < a.length; i++) {

            // then we place j in same position is on i is
            for (int j = i; j < a.length; j++) {

                // then we print number between i and j both including using k
                for (int k = i; k <= j; k++) {

                    System.out.print(a[k] + "\t");
                    
                }
                System.out.println();
            }
        }
    }

}

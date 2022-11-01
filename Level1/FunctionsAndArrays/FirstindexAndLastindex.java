import java.io.*;
import java.util.*;

public class FirstindexAndLastindex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int first_idx = firstOccurance(a, k);
        int last_idx = lastOccurance(a, k);
        System.out.println(first_idx);
        System.out.println(last_idx);
    }

    public static int firstOccurance(int[] a, int k) {
        int low = 0, high = a.length - 1;
        int first_idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < k) {

                low = mid + 1;
            } else if (a[mid] > k) {
                high = mid - 1;
            } else {
                high = mid - 1;
                first_idx = mid;
            }

        }
        return first_idx;

    }

    public static int lastOccurance(int[] a, int k) {
        int low = 0, high = a.length - 1;
        int last_idx = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < k) {
                low = mid + 1;
            } else if (a[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
                last_idx = mid;
            }
        }
        return last_idx;
    }

}

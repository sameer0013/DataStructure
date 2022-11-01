
import java.util.*;

public class RotateOfNumber {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int temp = n;
        int k = scn.nextInt();
        int count = 0;
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        k = k % count;

        if (k < 0) {
            k = k + count;
        }
        int tmp1 = (int) Math.pow(10, k);
        int p1 = n / tmp1;
        int p2 = n % tmp1;
        int tmp2 = (int) Math.pow(10, count - k);
        int ans = (p2 * tmp2) + p1;
        System.out.println(ans);

    }
}

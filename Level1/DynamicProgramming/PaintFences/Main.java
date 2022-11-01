import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        // System.out.println(paintFence(n,k));
        System.out.println(paintFence_Opt(n,k));

    }

    public static long paintFence(int n, int k){
        int[][] dp = new int[3][n+1];
        dp[0][2] = k;
        dp[1][2] = k*(k-1);
        dp[2][2] = dp[1][2]+dp[0][2];

        for(int i =3;i<=n;i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[2][i-1]*(k-1);
            dp[2][i] = dp[1][i]+dp[0][i];
            // System.out.println(dp[2][i]);
        }
        return dp[2][n];
    }

    public static int paintFence_Opt(int n , int k){
        int same = k;
        int diff = k*(k-1);
        int total = same+diff;

        for(int i=3;i<=n;i++){
            same = diff;
            diff = total*(k-1);
            total = same+diff;
        }
        return total;
    }
}
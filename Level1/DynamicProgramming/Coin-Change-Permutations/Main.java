import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=scn.nextInt();
        }
        int amt = scn.nextInt();

        System.out.println(permutation(coins,amt));

    }

    public static int permutation(int[] coins,int target){
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int tar =1;tar<dp.length;tar++){
            for(int coin:coins){
                if(coin<=tar){
                    dp[tar] += dp[tar-coin]; 
                }
            }
        }
        return dp[target];
    }
}
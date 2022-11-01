import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        for(int i=0;i<n;i++)  val[i]=scn.nextInt();
        
        for(int i=0;i<n;i++)  wt[i]=scn.nextInt();

        int cap = scn.nextInt();

        System.out.println(knapsack_tab(val,wt,cap));
        

    }

    public static int knapsack_tab(int[] value,int[] weight,int capacity){
        int n = value.length;
        int[][] dp = new int[n+1][capacity+1];

        for(int i=1;i<=n;i++){
            for(int cap =1;cap<=capacity;cap++){
                int v = value[i-1];
                int wt = weight[i-1];
                if(cap>=wt){
                    //include and exclude both
                    int inc = v+dp[i-1][cap-wt];
                    int exc = dp[i-1][cap];
                    dp[i][cap]=Math.max(inc,exc);

                }else{
                    //exclude
                    dp[i][cap]=dp[i-1][cap];
                }
            }
        }

        return dp[n][capacity];
    }
}
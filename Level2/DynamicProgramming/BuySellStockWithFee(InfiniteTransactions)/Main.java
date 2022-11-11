import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new  int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int fee = scn.nextInt();
        // int[][] dp = new int[n][2];
        // maxProfit(arr,fee,dp);
        System.out.println(maxProfit(arr,fee));
    }
    
    public static void maxProfit(int[] prices,int fee, int[][] dp){
        dp[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            //buy
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            
            // sell
           dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
            
        }
    }

    public static int  maxProfit(int[] prices,int fee){
        int buy =0,sell =0;
        buy = -prices[0];
        
        for(int i=1;i<prices.length;i++){
            //buy
            int nbuy = Math.max(buy,sell-prices[i]);
            
            // sell
           int nsell = Math.max(sell,buy+prices[i]-fee);
           
           buy = nbuy;
           sell = nsell;
            
        }
        
        return sell;
    }

}
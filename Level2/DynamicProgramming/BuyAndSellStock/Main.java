import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
    
    public static int maxProfit(int[] prices){
        int sellDay =0,buyDay=0;
        int profit =0;
        while(sellDay<prices.length){
            if(prices[sellDay]<prices[buyDay]){
                buyDay = sellDay;
            }
            
            profit = Math.max(profit,prices[sellDay]-prices[buyDay]);
            sellDay++;
        }
        
        return profit;
    } 

}
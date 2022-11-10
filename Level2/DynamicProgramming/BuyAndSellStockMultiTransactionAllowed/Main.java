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
        
        int ans = maxProfitMultiTriAllow(arr);
        System.out.println(ans);
    }
    
    public static int maxProfitMultiTriAllow(int[] prices){
        int sellDay =0,buyDay=0;
        int profit =0;
        while(sellDay<prices.length-1){
            
            if(prices[sellDay]>prices[sellDay+1]){
                // when there is dip in stock
                profit += prices[sellDay]-prices[buyDay];
                buyDay = sellDay+1;
            }
            sellDay++;
        }
        
        if(prices[sellDay]>prices[buyDay]){
            profit += prices[sellDay]-prices[buyDay];
        }
        return profit;
    } 

}
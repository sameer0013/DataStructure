import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i]= scn.nextInt();
        }
        
        int[] bSellProfitTillNow = new int[n];
        int maxProfit=0;
        int buyingDay=0;
        for(int sellingDay=0;sellingDay< n;sellingDay++){
            int profit = prices[sellingDay] - prices[buyingDay];
            if(profit<0){
                buyingDay = sellingDay;
            }
            maxProfit = Math.max(profit,maxProfit);
            bSellProfitTillNow[sellingDay] = maxProfit;
        }
        
        // System.out.println(Arrays.toString(bSellProfitTillNow));
        int[] bBuyProfitTillNow = new int[n];
        maxProfit =0;
        int sellingDay =n-1;
        for(int buyday =n-1;buyday>=0;buyday--){
            int profit =  prices[sellingDay]-prices[buyday]  ;
            if(profit <0){
                sellingDay = buyday;
            }
            maxProfit = Math.max(profit,maxProfit);
            bBuyProfitTillNow[buyday] = maxProfit;
        }
        // System.out.println(Arrays.toString(bBuyProfitTillNow));
        maxProfit =0;
        
        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit ,bBuyProfitTillNow[i]+bSellProfitTillNow[i]);
        }
        
        System.out.println(maxProfit);
    }

}
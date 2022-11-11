import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++){
            prices[i] = scn.nextInt();
        }
        
        int buy=0,sell=0,cooldown =0;
        for(int i=0;i<n;i++){
            if(i==0){
                buy = -prices[i];
            }else{
                int nbuy = Math.max(buy,cooldown - prices[i]);
                int nsell = Math.max(sell,buy+prices[i]);
                int ncool = sell;
                
                buy = nbuy;
                sell = nsell;
                cooldown = ncool;
            }
        }
        
        System.out.println(sell);
    }

}
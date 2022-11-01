import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = scn.nextInt();

        System.out.println(maximumSum(arr));

    }

    public static int maximumSum(int[] arr){
        int dp[][]= new int[2][arr.length];

        for(int i=0;i<arr.length;i++){
            if(i==0){
                dp[0][i]=0;
                dp[1][i]=arr[i];
            }else{
                int enc = dp[0][i-1];
                int inc = dp[1][i-1];
                dp[0][i]=Math.max(enc,inc);
                dp[1][i]=arr[i]+enc; 
            }

            
        }
        return Math.max(dp[0][arr.length-1],dp[1][arr.length-1]);
    }
}
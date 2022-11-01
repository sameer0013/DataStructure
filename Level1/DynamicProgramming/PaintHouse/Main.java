import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][]= new int[n][3];
        for(int i=0;i<n;i++){
            for(int c =0;c<3;c++){
                arr[i][c]=scn.nextInt();
            }
        }

        System.out.println(paintHouse(arr));

    }

    public static int paintHouse(int[][] arr){
        int n =arr.length;
        int dp[][] = new int[n][3];

        for(int i =0;i<n;i++){
            if(i==0){
                dp[i][0]=arr[i][0];
                dp[i][1]=arr[i][1];
                dp[i][2]=arr[i][2];
            }else{
                dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
                dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
                dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
            }
        }
        int min =Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        return min;
    }
}
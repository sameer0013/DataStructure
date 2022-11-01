import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        // System.out.println(countABC(str));
        System.out.println(countABC_Opt(str));

    }

    public static int countABC(String str){
        int[][] dp = new int[3][str.length()];
        if(str.charAt(0)=='a'){
            dp[0][0]=1;
        }

        for(int i =1;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a'){
                dp[0][i]=2*dp[0][i-1] + 1;
                dp[1][i]=dp[1][i-1];
                dp[2][i]=dp[2][i-1];

            }else if(ch=='b'){
                dp[0][i]=dp[0][i-1];
                dp[1][i]=2*dp[1][i-1] + dp[0][i-1];
                dp[2][i]=dp[2][i-1];

            }else if(ch=='c'){
                dp[0][i]=dp[0][i-1];
                dp[1][i]=dp[1][i-1];
                dp[2][i]=2*dp[2][i-1] + dp[1][i-1];
            }

        } 
        return dp[2][str.length()-1];
    }

    public static int countABC_Opt(String str){
        int apluscount=0;
        int abpluscount=0;
        int abcpluscount=0;

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a'){
                apluscount = 2*apluscount +1;
            }else if(ch=='b'){
                abpluscount = 2*abpluscount +apluscount;
            }else if(ch=='c'){
                 abcpluscount = 2*abcpluscount +abpluscount;
            }
        }
        return abcpluscount;
    }
}
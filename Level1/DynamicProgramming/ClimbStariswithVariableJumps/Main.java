import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] moves = new int[n];
        for(int i=0;i<n;i++){
            moves[i]=scn.nextInt();
        }
        // System.out.println(climbStairsWithJump_rec(0,n,moves));
        // int[] mem = new int[n+1];
        // Arrays.fill(mem,-1);
        // System.out.println(climbStairsWithJump_mem(0,n,moves,mem));
        // System.out.println(climbStairsWithJump_tab(0,n,moves));
        System.out.println(climbStairsWithJump_Opttab(moves));
    }

    public static int climbStairsWithJump_rec(int currstep,int tortalstep,int[] moves){
        if(currstep==tortalstep){
            return 1;
        }

        int ans=0;
        int maxstep=moves[currstep];
        for(int step=1;step<=maxstep;step++){
            if(currstep+step<=tortalstep){
                ans += climbStairsWithJump(currstep+step,tortalstep,moves);
            }

        }
        return ans;
    }


    public static int climbStairsWithJump_mem(int currstep,int tortalstep,int[] moves,int[] mem){
        if(currstep==tortalstep){
            return mem[currstep]=1;
        }

        if(mem[currstep]!=-1){
            return mem[currstep];
        }

        int ans=0;
        int maxstep=moves[currstep];
        for(int step=1;step<=maxstep;step++){
            if(currstep+step<=tortalstep){
                ans += climbStairsWithJump_mem(currstep+step,tortalstep,moves,mem);
                
            }

        }
        return mem[currstep]=ans;
    }

    public static int climbStairsWithJump_tab(int currstep,int totalstep,int[]moves){
        int n = totalstep;
        int[] mem = new int[n+1];
        for(int i=n;i>=0;i--){
            if(i==n){
                mem[i]=1;
            }
            else{
                int maxstep = moves[i];
                for(int step=1;step<=maxstep;step++){
                    if(i+step<=n){
                        mem[i] +=mem[i+step];
                    }
                }   
            }
        }
        return mem[currstep];
    }

    public static int climbStairsWithJump_Opttab(int[] moves){
        int n =moves.length;
        int[] mem = new int[n+1];

        mem[n]=1;
        for(int i=n-1;i>=0;i--){
            for(int step = i+1;step<=Math.min(n,i+moves[i]);step++){
                mem[i] += mem[step];
            }

        }
        return mem[0];
    }

}
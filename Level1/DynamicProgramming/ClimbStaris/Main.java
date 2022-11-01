import java.util.*;
public class Main {
    
    public static int cb_rec(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int ans = cb_rec(n-1)+cb_rec(n-2)+cb_rec(n-3);
        return ans;
    }

    public static int cb_mem(int n,int[] mem){
        if(n==0){
            return mem[n]=1;
        }
        else if(n==1||n==2) {
            return mem[n]=n;
        }
        if(mem[n]!=0){
            return mem[n];
        }

        int ans = cb_mem(n-1, mem)+cb_mem(n-2, mem)+cb_mem(n-3, mem);
        return mem[n]=ans;
    }

    public static int cb_tab(int n){
        int [] mem = new int[n+1];
        for(int i=0;i<=n;i++){

            if(i==0){
                mem[i]=1;
            }else if(i==1||i==2){
                mem[i]=i;
            }else{
                mem[i]=mem[i-1]+mem[i-2]+mem[i-3];
            }
        }

        return mem[n];
    }

    public static int cb_optTab(int n){
        if(n==0) return 1;
        else if(n==1||n==2){
            return n;
        }
        int f=1,s=1,t=2;
        for(int i=3;i<=n;i++){
            int l =f+s+t;
            f=s;
            s=t;
            t=l;
        }
        return t;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        System.out.println(cb_rec(n));
        System.out.println(cb_mem(n, new int[n+1]));
        System.out.println(cb_tab(n));
        System.out.println(cb_optTab(n));
    }
}

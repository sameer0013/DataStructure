import java.util.*;
public class Main{
    public static int fib_rec(int n){
        if(n==0||n==1){
            return n;
        }
        int fib = fib_rec(n-1)+fib_rec(n-2);
        return fib;
    }


    public static int fib_mem(int n, int[] mem){
        if(n==0||n==1){
            return mem[n]=n;
        }
        if(mem[n]!=0){
            return mem[n];
        }
        mem[n] = fib_mem(n-1,mem) + fib_mem(n-2,mem);

        return mem[n];

    }

    public static int fib_tab(int n){
        int mem[] = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0||i==1){
                mem[i]=i;
            }else{
                mem[i]=mem[i-1]+mem[i-2];
            }
        }
        return mem[n];
    }

    public static int fib_optTab(int n){
        if(n==0||n==1){
            return n;
        }
        int f=0,s=1;
        for(int i =2;i<=n;i++){
            int t =f+s;
            f=s;
            s=t;
        }

        return s;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(fib_rec(n));
        System.out.println(fib_mem(n, new int[n+1]));
        System.out.println(fib_tab(n));
        System.out.println(fib_optTab(n));

    }
}
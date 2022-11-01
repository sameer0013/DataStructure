import java.io.*;
import java.util.*;
public class PowerLogarithm  {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        int xpow=power(x,n);
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int xpn2= power(x,n/2);
        int xn=xpn2*xpn2;
        if(n%2!=0){
            xn=xn*x;
        }
        return xn;
        
    }

}

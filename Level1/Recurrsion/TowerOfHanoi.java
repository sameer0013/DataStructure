
import java.io.*;
import java.util.*;

public class TowerOfHanoi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn =new Scanner(System.in);
        int n=scn.nextInt();
        int src=scn.nextInt();
        int dest=scn.nextInt();
        int helper=scn.nextInt();
        toh(n,src,dest,helper);
    }

    public static void toh(int n, int src, int dest, int helper){
        if(n==0){ //basecase
            return;
        }
        toh(n-1,src,helper,dest);//faith
        System.out.println(n+"["+src+" -> "+dest+"]");
        toh(n-1,helper,dest,src); //faith       
    }

}

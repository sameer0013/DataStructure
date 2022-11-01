import java.io.*;
import java.util.*;

public class Pdi {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        pdi(n);
    }

    public static void pdi(int n){ // print decreasing increasing
        if(n==0){//base case
            return;

        }
        System.out.println(n);
        pdi(n-1);//faith
        System.out.println(n);
    }

}

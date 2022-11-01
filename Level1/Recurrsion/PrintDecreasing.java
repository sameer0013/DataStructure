import java.io.*;
import java.util.*;

public class PrintDecreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        if(n==0){   //base case
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);   //faith
    }

}

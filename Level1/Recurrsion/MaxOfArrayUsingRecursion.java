import java.io.*;
import java.util.*;

public class MaxOfArrayUsingRecursion {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int max=maxOfArray(arr,0); // function is expected to return max element from 0th to (n-1)pos of an array
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length){   //Base class
            return Integer.MIN_VALUE; // it gives smallest integer value
        }

        int rres=maxOfArray(arr,idx+1); //faith

        if (rres>arr[idx]) {
            return rres;
        } else {
            return arr[idx];
        }
        
    }

}

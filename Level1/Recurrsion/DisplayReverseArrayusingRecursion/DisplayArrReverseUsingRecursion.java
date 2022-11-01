import java.io.*;
import java.util.*;

public class DisplayArrReverseUsingRecursion  {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        //displayArrReverse(arr,0); // function  expected to display elements from (n-1)pos to 0th pos
        displayArrReverse2(arr,arr.length-1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if(idx==arr.length){
            return;
        }
        displayArrReverse(arr,idx+1);
        System.out.println(arr[idx]);
    }

    public static void displayArrReverse2(int[] arr, int idx) {
        if(idx==-1){
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse2(arr,idx-1);
    }

}

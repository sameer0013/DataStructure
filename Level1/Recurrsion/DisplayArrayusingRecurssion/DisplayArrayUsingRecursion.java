import java.io.*;
import java.util.*;

public class DisplayArrayUsingRecursion  {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
       }
    //displayArr(arr,0); //function is expected to print from 0th pos to (n-1)pos
    
    displayArr2(arr,arr.length-1); //function is expected to print from 0th pos to (n-1)pos
    }

    public static void displayArr(int[] arr, int idx){
        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr,idx+1);
    }

    public static void displayArr2(int[] arr,int idx){
        if(idx==-1){
            return;
        }
        displayArr2(arr,idx-1);
        System.out.println(arr[idx]);
    }

}

import java.io.*;
import java.util.*;

public class LastIndexUsingRecursion
 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int x=scn.nextInt();
        int idx=lastIndex(arr,arr.length-1,x);
        System.out.println(idx);
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx==-1){
            return -1;

        }
        if(arr[idx]==x){
            return idx;
        }else{
            return lastIndex(arr,idx-1,x);
        }

    }

}

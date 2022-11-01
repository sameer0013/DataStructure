import java.io.*;
import java.util.*;

public class Findelement {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    
    int arr[]=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=scn.nextInt();
    }
    int ele=scn.nextInt();
    int res = find(arr,ele);
    System.out.println(res);
 }
 public static int find(int arr[],int ele){
     for(int i=0;i<arr.length;i++){
         if(arr[i]==ele){
             return i;
         }
     }
     return -1;
 }

}


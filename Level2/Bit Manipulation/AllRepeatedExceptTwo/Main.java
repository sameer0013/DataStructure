package AllRepeatedExceptTwo;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   int ans =arr[0];
   for(int i=1;i<arr.length;i++){
       ans = ans^arr[i];
   }
   
   int mask = ans & ((~ans)+1);
   int x=0,y=0;
   for(int vl:arr){
       if((vl&mask)==0){
           x ^= vl;
       }else{
           y ^=vl;
       }
   }
   System.out.println((x<y)?x:y);
   System.out.println((x<y)?y:x);
  }

}

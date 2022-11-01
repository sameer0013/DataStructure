package AllRepeatedExceptOne;

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
    //write your code here
    int ans=arr[0];
    for(int i=1;i<arr.length;i++){
        ans = (ans ^ arr[i]);
    }
    System.out.println(ans);
    
  }

}
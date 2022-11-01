import java.io.*;
import java.util.*;

public class SpanofArray 
{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
    int ar[]=new int[n];
    for(int i=0;i<=n-1;i++){
        ar[i]=scn.nextInt();
    }
    int res = span(ar);
    System.out.println(res);
 }
 public static int span(int ar[]){
     int max=ar[0];
     int min=ar[0];
     for(int i=1;i<ar.length;i++){
         if(ar[i]>max){
             max=ar[i];
         }
         if(ar[i]<min){
             min=ar[i];
         }

     }
     return (max-min);
 }

}

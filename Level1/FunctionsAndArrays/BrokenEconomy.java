
import java.io.*;
import java.util.*;
public class BrokenEconomy 
{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n =scn.nextInt();
    int[] a=new int[n];
    for(int i=0;i<a.length;i++){
        a[i]=scn.nextInt();
    }
    int k=scn.nextInt();
    brokenEconomy(a,k);
 }
 // based on binary search approach
 public static void brokenEconomy(int[] a,int k){
     int st=0,ed=a.length-1;
     int floor=-1 ,ciel=-1;
     while(st<=ed){
         int mid=(st+ed)/2;
         if(a[mid]<k){
             st=mid+1;
             floor=mid;
         }else if(a[mid]>k){
             ed=mid-1;
             
             ciel=mid;

         }else{
             ciel=mid;
             floor=mid;
             break;
         }

     }
        // int ciel=st;
        // int floor=ed;
         System.out.println(a[ciel]);
         System.out.println(a[floor]);
 }

}

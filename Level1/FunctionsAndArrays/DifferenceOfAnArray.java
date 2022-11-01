import java.io.*;
import java.util.*;

public class DifferenceOfAnArray
{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1=scn.nextInt();
    int[] a1= new int[n1];
    for(int i=0;i<a1.length;i++){
        a1[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int[] a2=new int[n2];
    for(int i=0;i<a2.length;i++){
        a2[i]=scn.nextInt();
    }

    int res[]=difference(a1,a2);

    int i=0;
    while(i<res.length&&res[i]==0){
        i++;
    }
    while(i<res.length){
        System.out.println(res[i]);
        i++;
    }
 }
 public static int[] difference(int[] a1,int[] a2){
     int n1=a1.length,n2=a2.length,p1=a1.length-1,p2=a2.length-1;
     int carry=0;
     int n3=Math.max(n1,n2);
     int p3=n3-1;
     int res[]=new int[n3];
     while(p1>=0||p2>=0){
         int v1=p1>=0?a1[p1]:0;
         int v2=p2>=0?a2[p2]:0;
         v2=v2-carry;
        if(v1>v2){
            v2=v2+10;
            carry=1;
        }
        else{
            v2=v2;
            carry=0;
        }
        int dif=v2-v1;
        res[p3]=dif;
        p1--;
        p2--;
        p3--;
     }
     return res;
 }

}

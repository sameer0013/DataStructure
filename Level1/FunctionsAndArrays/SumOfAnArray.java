
import java.io.*;
import java.util.*;

public class SumOfAnArray   
{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1=scn.nextInt();
    int[] a1=new int[n1];
    for(int i=0;i<a1.length;i++){
        a1[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int[] a2=new int[n2];
    for(int i=0;i<a2.length;i++){
        a2[i]=scn.nextInt();
    }

    int[] res=sum(a1,a2);
    for(int v1:res){
        System.out.println(v1);
    }
 }
 public static int[] sum(int[] a1,int[] a2){
     int n1=a1.length,n2=a2.length;
     int n=Math.max(n1,n2);
     int p1=n1-1,p2=n2-1,p3=n-1,carry=0;
     int[] res= new int[n];
     while(p1>=0||p2>=0){
         int v1= p1>=0?a1[p1]:0; //ternary operator
         int v2= p2>=0?a2[p2]:0;

         int sum=v1+v2+carry;
         int digit=sum%10;
         carry=sum/10;
         res[p3]=digit;
         p1--;
         p2--;
         p3--;

     }
     if(carry!=0){
         int[] newres= new int[n+1];
         newres[0]=carry;
         for(int i=1;i<newres.length;i++){
             newres[i]=res[i-1];

         }
         return newres;
     }
     return res;
 }

}

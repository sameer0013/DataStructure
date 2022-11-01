
import java.util.*;
public class AnyBaseToAnyBase 
{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int any=anyBaseAny(n,sourceBase,destBase);
     System.out.println(any);
   }   
   public static int anyBaseAny(int n,int sb,int db){
      int n1=anyBasetoDecimal(n,sb);
      return decimalToAny(n1,db);
   }
   public static int anyBasetoDecimal(int n,int b){
     int ans =0;
     int power=1;
     while(n>0){
       int r=n%10;
       n=n/10;
       ans +=r*power;
       power *=b;
     }
     return ans;
   }
   public static int decimalToAny(int n,int b) {
     int ans =0;
     int power=1;
     while(n>0){
       int r=n%b;
       n=n/b;
       ans +=r*power;
       power *=10;
     }
     return ans;
     
   }
  }

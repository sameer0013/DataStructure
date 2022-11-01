import java.util.*;

public class AnyBaseAddition 
{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans =0;
       int power=1;
       int carry=0;
       while(n1>0||n2>0||carry==1){
           int r1=n1%10!=0?n1%10:0;
           int r2=n2%10!=0?n2%10:0;
           int s=r1+r2+carry;
        //    if(b<=s){
        //        carry=1;
        //        s=s%b;;
        //    }else{
        //        carry=0;
        //    }
           carry=s/b;
           s=s%b;
           ans += s*power;
           power *=10;
           n1=n1/10;
           n2=n2/10;
       }

       return ans;
   }
  }

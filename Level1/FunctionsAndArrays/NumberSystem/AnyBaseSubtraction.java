import java.util.*;

public class AnyBaseSubtraction {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       int ans =0;
       int power=1;
       int carry=0;
       while(n1>0||n2>0){
           int r1=n1%10;
           int r2=n2%10;
           r2=r2-carry;
           if(r2<r1){
               r2=r2+b;
               carry=1;
           }else{
               carry=0;
           }
           ans +=(r2-r1)*power;
           power*=10;
           n1=n1/10;
           n2=n2/10;

       }
       return ans;
   }
  
  }

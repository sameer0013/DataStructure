import java.util.*;

public class AnyBaseMultiplication {

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
     int ans2=0;
     int power=1;
     
     while(n2>0)
     {
        int r2=n2%10;
        int ans =getProductByDigit(n1,b,r2);
        ans = ans*power;

        ans2=getSum(b,ans2,ans);
        
        power *= 10;
        n2=n2/10;
     }
    return ans2;
 }
 public static int getProductByDigit(int n1,int b,int r2) {
     
        int carry=0;
        int ans=0;
        int mul=1;
        while(n1>0||carry>0)
        {
            int r1=n1%10;
            int d=(r1*r2)+carry;
            int r=d%b;
            carry=d/b;
            ans +=r*mul;
            mul *= 10;
            n1=n1/10;

        }
        return ans;
     
 }
  public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans =0;
       int power=1;
       int carry=0;
       while(n1>0||n2>0||carry==1){
           int r1=n1%10;
           int r2=n2%10;
           int s=r1+r2+carry;

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

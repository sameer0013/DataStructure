import java.util.*;

public class InverseOfDigit{

public static void main(String[] args) {
  // write your code here  
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  int count=0;
  int ans=0;
  while(n!=0){
    int rem = n%10;
    count++;
    int power=(int)Math.pow(10,rem-1);
    ans += (power*count);
    n=n/10;
  }
  System.out.println(ans);
 }
}

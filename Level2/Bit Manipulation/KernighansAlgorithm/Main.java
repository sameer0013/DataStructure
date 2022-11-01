
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    System.out.println(kernighans(n));
  }
  public static int kernighans(int n){
      int count=0;
      while(n!=0){
          n ^= n&(~n+1);
          count++;
      }
      return count;
  }
  public static int kernighans2(int n){
      int count=0;
      while(n!=0){
          n &= n-1;
          count++;
      }
      return count;
  }

}
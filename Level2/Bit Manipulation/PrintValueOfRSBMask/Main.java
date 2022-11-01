package PrintValueOfRSBMask;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //write your code here
    int ans = rsbMaskValue(n);
   System.out.print(Integer.toBinaryString(ans));
  }
 
  public static int rsbMaskValue(int n){
      int neg = (~n)+1;
      return n&neg;
      
  }

}
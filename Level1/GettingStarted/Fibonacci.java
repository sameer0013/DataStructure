import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a=0;
        int b=1;
       
        int c=0;
        // for(int i=0;i<n;i++){
        //   System.out.println(a);
        //   c=a+b;
          
        //   a=b;
        //   b=c;
          
        // }
        int i=1;
        while(i<=n){
          c=a+b;
          System.out.println(a);
          a=b;
          b=c;
          i++;
        }
     }
}
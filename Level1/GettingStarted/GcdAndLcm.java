import java.util.*;
    
    public class GcdAndLcm{
    
    public static void main(String[] args)
    {

      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      int num1=n1,num2=n2;
      while(n1%n2!=0)
      {
        int rem = n1%n2;
        n1=n2;
        n2=rem;
      }
      System.out.println(n2);
      int lcm = (num1*num2)/n2;
      System.out.println(lcm);

        

      
     }
    }

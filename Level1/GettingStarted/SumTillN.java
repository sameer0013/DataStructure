import java.util.Scanner;
public class SumTillN {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n =scn.nextInt();
        // int sum=0;
        // for(int i =1;i<=n;i++)
        // {
        //     sum=sum+i;
            
        // }
        // System.out.println(sum);
        int sum = (n*(n+1))/2;
        System.out.println(sum);

    }
}
    


import java.util.Scanner;

public class PrimeOrNot {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count=0;
        for(int i=0;i<n;i++)
        {
            int t= scn.nextInt();
            for(int j=2; j<=(int)Math.sqrt(n);j++)
            {
            
                if(t%j==0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                System.out.println("prime");
            }
            else{
                System.out.println("not prime");
            }
        }
    }
}

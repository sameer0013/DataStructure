import java.util.Scanner;
public class DigitOfNumber {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count=1;
        int temp=n;
        while(n>9){
            n=n/10;
            count *= 10;
        }
        // System.out.println(count);
        
        while(temp!=0){
            int q=temp/count;
            System.out.println(q);
            temp=temp%count;
            count=count/10;
        }
    }
    
}

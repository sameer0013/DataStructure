import java.util.Scanner;

public class RecursiveDilemma
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        recursiveCode(n);
    }
    public static void recursiveCode(int n){
        
        // code here
        if(n==1){
            System.out.print(n+" ");
            return ;
        }
        recursiveCode(n-1);
        System.out.print(n+" ");
        recursiveCode(n-1);
        
        return;
        
    }
}

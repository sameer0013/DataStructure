import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        printIncreasing(n);
    }
    public static void printIncreasing(int n){
        if (n==0){ //base case
            return ;
        }
        printIncreasing(n-1); //faith

        System.out.println(n);
    }
}
// 3
// ***  *****  *  *****  ***
// ***   ***  ***  ***   ***
// ***    *  *****  *    ***
import java.util.Scanner;

public class MadAngels 
{	
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp=2;
        int sp2=2;
        int star1=(2*n)-1;
        int star2=1;
        // write your code here
        for(int i=0;i<n;i++){
            printStars(n);
            printSpaces(sp);
            printStars(star1);
            printSpaces(sp2);
            printStars(star2);
            printSpaces(sp2);
            printStars(star1);
            printSpaces(sp);
            printStars(n);
            System.out.println();
            star1-=2;
            star2 +=2;
            sp+=1;
        }    
        
    }

    public static void printStars(int n){
        for(int i = 1 ; i <= n ;i++){
            System.out.print("*");
        }
    }

    public static void printSpaces(int n){
        for(int i = 1 ; i <= n ;i++){
            System.out.print(" ");
        }
    }
}

// *                               *
// *       *               *       *
// *               *               *
// *                               *
// *                               *
import java.util.Scanner;

public class PatternM {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        for(int r=1;r<=n;r++){
            for(int c=1;c<=n;c++){
                if(c==1||c==n||(r==c||r+c==n+1)&&(r<=n/2+1)){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}

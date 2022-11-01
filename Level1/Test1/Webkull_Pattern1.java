
// 7
// @@@@@@@
//       *   
//       **  
//       *** 
//       ****
//       *** 
//       **  
//       *   
//      @@@@@@@
import java.util.Scanner;

public class Webkull_Pattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int stars=1;
        int spaces=n/2;
        int lenr=n+2;
        
        // code here
        for(int r=1;r<=lenr;r++){
            if(r==1){
                for(int c=1;c<=n;c++){
                    System.out.print("@");
                }
            }
            else if(r>1&&r<lenr)
            {
                for(int c=1;c<n;c++){
                    System.out.print(" ");
                }
                for(int c=1;c<=stars;c++){
                    System.out.print("*");
                }
                for(int c=1;c<=spaces;c++){
                    System.out.print(" ");
                }
                if(r<=(n/2)+1){
                    spaces -=1;
                    stars+=1;
                }else{
                    spaces+=1;
                    stars-=1;
                }
            }
            else if(r==lenr){
                for(int c=1;c<n-1;c++){
                    System.out.print(" ");
                }
                for(int c=1;c<=n;c++){
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }
}
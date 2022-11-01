import java.util.Scanner;

public class WelcomeRangolie
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        int  m = scn.nextInt();
        
        // code here
        int col=(m-3)/2;
        int strick=1;
        int pat=(m-7)/2;
        for(int i=1;i<=n;i++){
               
            
            if(i==(n+1)/2){
                for(int j =1;j<=pat;j++){
                    System.out.print("-");
                }
                System.out.print("WELCOME");
                for(int j =1;j<=pat;j++){
                    System.out.print("-");
                }
            }
            if(i<(n+1)/2){
                 for(int j=1;j<=col;j++){
                    System.out.print("-");
                }
                for(int j=1;j<=strick;j++){
                    System.out.print(".|.");
                }
                for(int j=1;j<=col;j++){
                    System.out.print("-");
                }
                col =col-3;
                strick +=2;
                
            }
            else if(i>(n+1)/2){
                col =col+3;
                strick -=2;  
                 for(int j=1;j<=col;j++){
                    System.out.print("-");
                }
                for(int j=1;j<=strick;j++){
                    System.out.print(".|.");
                }
                for(int j=1;j<=col;j++){
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
    
}

// 7
// *	*	*	*	*	*	*	
// 	*				*	
// 		*		*	
// 			*	
// 		*	*	*	
// 	*	*	*	*	*	
// *	*	*	*	*	*	*
import java.util.Scanner;

public class HourGlass6 
 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // code here  
        int star=n;
        
        int spaces=0;
        int stars2=1;
        int spaces2=n/2;
        for(int r=0;r<n;r++){
              for(int c=0;c<spaces;c++){
                
                System.out.print("\t");
            }
            for(int c=0;c<star;c++){
                if(r<n/2&&r>0){
                    if(c==0||c==star-1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }else{
                    System.out.print("*\t");
                }
            }
            for(int c=0;c<spaces;c++){
                
                System.out.print("\t");
            }
            if(r<n/2){
                
             spaces+=1;
             star -=2;
             
            
            }  
            else{
             spaces-=1;
             star +=2;
                
            }
            System.out.println();
            
        }
    }

}

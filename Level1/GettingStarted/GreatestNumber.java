import java.util.*;
public class GreatestNumber{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        if(a>b){
            //a is larger than b 
            if(a>c){
                //a is larger than b as well as c
                System.out.println(a);
            }
            else{
                // a is greater than b but smaller than c; c>a>b
                System.out.println(c);
            }
          
        }
        
        
        else{
            // b is larger than a
            if(b>c){
                // b is larger than a as well as c
                System.out.println(b);
            }
            else{
                // b is larger than a but not with c
                System.out.println(c);
            }
        }

        // if(a>b &&a>c){
        //     System.out.println(a);
        // }
        // else if(b>c){
        //     System.out.println(b);

        // }
        // else{
        //     System.out.println(c);
        // }
        
    }
}
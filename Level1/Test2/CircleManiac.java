import java.io.*;
import java.util.*;

public class CircleManiac  {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        int x2 = scn.nextInt();
        int y2 = scn.nextInt();
        int r1 = scn.nextInt();
        int r2 = scn.nextInt();
        
        int d = (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
        //d = (int)Math.sqrt(d);
        int rad = (r1+r2)*(r1+r2);
        if (d==0){
            //concentric
            System.out.println("concentric");
        }else if(d==rad){
            //touch at 1 point
            System.out.println("touches at 1 point");
        }else if(d>rad){
            // far-apart
            System.out.println("far-apart");
        }else if(d<rad && d>(r1-r2)*(r1-r2)){
            // touch at 2 point
            System.out.println("touches at 2 point");
        }else{
            //overlaps
            System.out.println("overlaps");
        }
    }
}

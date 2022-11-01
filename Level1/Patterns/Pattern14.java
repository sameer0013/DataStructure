// 3 * 1 = 3
// 3 * 2 = 6
// 3 * 3 = 9
// 3 * 4 = 12
// 3 * 5 = 15
// 3 * 6 = 18
// 3 * 7 = 21
// 3 * 8 = 24
// 3 * 9 = 27
// 3 * 10 = 30
import java.util.*;
public class Pattern14 {
      public static void main(String[] args) {
            Scanner scn =new Scanner(System.in);
            int n =scn.nextInt();
            for(int x=1;x<=10;x++){
                  System.out.println(n+" * "+x+" = "+n*x);
            }
      }
}

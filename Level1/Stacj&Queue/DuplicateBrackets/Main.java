import java.util.*;
public class Main{
   public static void main(String[] args) {
      
      Scanner scn = new Scanner(System.in);
      String str = scn.nextLine() ;
      boolean hasduplicy = duplicy(str);
      System.out.println(hasduplicy);     
   }
   public static boolean duplicy(String exp){
      Stack<Character> st = new Stack<>();
      for(int i =0;i<exp.length();i++){
         char ch = exp.charAt(i);
         if(ch ==' ') {continue;}
         
         else if(ch ==')')
         {
            if(st.peek() =='('){
               return true;
             }
            else{
               while(st.peek() != '(')
               {
                  st.pop();
               }
               st.pop();
            }
         }else{
            st.push(ch);
         }
      
      }
      return false;
   }
}
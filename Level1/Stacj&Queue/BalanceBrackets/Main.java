import java.util.*;
public class Main{
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      String str = scn.nextLine();
      boolean hasbalnced = balancedBrackets(str);
      System.out.println(hasbalnced);
   }
   public static boolean balancedBrackets(String exp){

      Stack<Character> st = new Stack<>();

      for(int i =0;i<exp.length();i++){
         char ch = exp.charAt(i);
         if(ch=='('||ch=='['||ch=='{'){
            st.push(ch);
         }else if(ch==')'){
            if(st.size()==0) {
                return false;
            }
            else if(st.peek()!='('){
               return false;
            }else{
               st.pop();
            }
            
         }else if(ch=='}'){
           if(st.size()==0) {
                return false;
            }
            else if(st.peek()!='{'){
               return false;
            }else{
               st.pop();
            }

         }else if(ch==']'){
           if(st.size()==0) {
                return false;
            }
            else if(st.peek()!='['){
               return false;
            }else{
               st.pop();
            }

         }else {
            continue;
         }

      }
      if(st.size()!=0){
         return false;
      }
      return true;
   }
}
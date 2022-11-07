import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    infixConversion(exp);
 }

 public static void infixConversion(String s){

     Stack<String> postfix = new Stack<>();
     Stack<String> prefix = new Stack<>();
     Stack<Character> helper = new Stack<>();

     for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        
        if (ch=='('){
            helper.push(ch);
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(helper.size()>0 && helper.peek()!='(' && precedence(ch)>=precedence(helper.peek())){
                char op = helper.pop();
                makePostfix(postfix,op);
                makePrefix(prefix,op);
            }

            helper.push(ch);

        }else if((ch>='0' && ch<='9')||(ch>='a' && ch<='z')||(ch>='A'&&ch<='Z')){
            postfix.push(""+ch);
            prefix.push(""+ch);
        }else if(ch ==')'){
            while(helper.size()>0 && helper.peek()!='('){
                char op = helper.pop();
                makePostfix(postfix,op);
                makePrefix(prefix,op);
            }
            helper.pop();
         }
     }

     while(helper.size()>0){
        char ch = helper.pop();
        makePostfix(postfix,ch);
        makePrefix(prefix,ch);
     }

     System.out.println(postfix.pop());
     System.out.println(prefix.pop());
 }


 public static void makePostfix(Stack<String> postfix,char op){
    String v2 = postfix.pop(),v1 = postfix.pop();
    postfix.push(v1+v2+op);
 }
 public static void makePrefix(Stack<String> prefix,char op){
    String v2 = prefix.pop(),v1 = prefix.pop();
    prefix.push(op+v1+v2);
 }

 public static int precedence(char op){
     if(op=='+'||op=='-') return 2;
     return 1;
 }

}
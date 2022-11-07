import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    prefixEvalAndConv(exp);
 }

 public static void prefixEvalAndConv(String str){
     Stack<Integer> evaluate = new Stack<>();
     Stack<String> infix = new Stack<>();
     Stack<String> postfix = new Stack<>();

     for(int idx =str.length()-1;idx>=0;idx--){
        char ch = str.charAt(idx);

        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            makeEvaluate(evaluate,ch);
            makeInfix(infix,ch);
            makePostfix(postfix,ch);
        }else if(ch>='0'&&ch<='9'){
            evaluate.push(ch-'0');
            infix.push(""+ch);
            postfix.push(""+ch);
        }
     }

     System.out.println(evaluate.pop());
     System.out.println(infix.pop());
     System.out.println(postfix.pop());
 }

 public static void makeEvaluate(Stack<Integer> eval,char op){
     int v1 = eval.pop(),v2 = eval.pop();
     if(op=='+') eval.push(v1+v2);
     else if(op=='/') eval.push(v1/v2);
     else if(op=='-') eval.push(v1-v2);
     else if(op=='*') eval.push(v1*v2);
 }

 public static void makeInfix(Stack<String> infix,char op){
     String v1 = infix.pop(),v2 = infix.pop();
     infix.push("("+v1+op+v2+")");
 }

 public static void makePostfix(Stack<String> postfix,char op){
    String v1 = postfix.pop(), v2 = postfix.pop();
    postfix.push(v1+v2+op);
 }
}

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    postfixEvaluation(exp);
 }

 public static void postfixEvaluation(String str){
     Stack<Integer> eva = new Stack<>();
     Stack<String> pre = new Stack<>();
     Stack<String> in = new Stack<>();
     
     for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch >='0'&&ch <='9'){
            eva.push(ch-'0');
            pre.push(""+ch);
            in.push(""+ch);

        }else{
           evalHelper(eva,ch);
           infixHelper(in,ch);
           prefixHelper(pre,ch);
        }

     }
    System.out.println(eva.pop());
    System.out.println(in.pop());
    System.err.println(pre.pop());
 }

public static void evalHelper(Stack<Integer> eval,char ch){
    int v2 = eval.pop(),v1 = eval.pop();
    if(ch=='+') eval.push(v1+v2);
    if(ch=='-') eval.push(v1-v2);
    if(ch=='*') eval.push(v1*v2);
    if(ch=='/') eval.push(v1/v2);
}

public static void infixHelper(Stack<String> in,char op){
    String v2 = in.pop(),v1 = in.pop();

    in.push("("+v1+op+v2+")");
}

public static void prefixHelper(Stack<String> prefix,char op){
    String v2 = prefix.pop(),v1 = prefix.pop();

    prefix.push(op+v1+v2);
}

} MAIN {
    
}

/*1. Expression is balanced
  2. The only operators used are +, -, *, /
  3. Opening and closing brackets - () - are used to impact precedence of operations
  4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
  5. In two operators of equal precedence give preference to the one on left.
  6. All operands are single digit numbers.
 */


package StackAndQueues.InfixEvaluation;

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    infixEvaluation(exp);
 }

 public static void infixEvaluation(String str){
    Stack<Integer> operand = new Stack<>();
    Stack<Character> helper = new Stack<>();

    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);

        if(ch=='('){
            helper.push(ch);
        }

        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
            while(helper.size()>0 && helper.peek()!='('&& precendence(ch)>=precendence(helper.peek())){
                evaluate(operand,helper.pop());

            }
            helper.push(ch);

        }else if(ch>='0' && ch<='9'){
            operand.push(ch-'0');

        }else if(ch==')'){
            while(helper.peek()!='('){
                evaluate(operand,helper.pop());
            }
            helper.pop();
        }
    }


    while(helper.size()>0){
        evaluate(operand,helper.pop());
    }

    System.out.println(operand.pop());
 }

 public static void evaluate(Stack<Integer> oper, char op){
     int v2 = oper.pop(),v1=oper.pop();
     if(op=='+') oper.push(v1+v2);
     if(op=='-') oper.push(v1-v2);
     if(op=='*') oper.push(v1*v2);
     if(op=='/') oper.push(v1/v2);
     
 }

 public static int precendence(char op){
     if(op=='+'||op=='-') return 2;
    
     return 1; //for *,/
 }
}

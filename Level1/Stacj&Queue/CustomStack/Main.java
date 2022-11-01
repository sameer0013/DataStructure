import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int tos;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;
    }

    int size() {
      // write ur code here
      return tos+1;
    }

    void display() {
      // write ur code here
      for(int idx = tos ;idx>=0;idx--){
        System.out.print(data[idx]+" ");
      }
      System.out.println();
    }

    void push(int val) {
      // write ur code here
      if(data.length == this.size()){
        System.out.println("Stack overflow");
        return;
      }
      
      data[tos+1] = val;
      tos++;
    }

    int pop() {
      // write ur code here
      if(this.size() == 0){
        System.out.println("Stack underflow");
        return -1;
      }else{

        int val = data[tos];
        tos--;
        return val;
      }
    }

    int top() {
      if(this.size() == 0){
        System.out.println("Stack underflow");
        return -1;
      }
       // write ur code here
       return data[tos];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}
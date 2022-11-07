import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int ans[] = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(-1);
   for(int idx=0;idx<arr.length;idx++) {
    while(st.peek()!=-1 && arr[idx]>arr[st.peek()]){
      st.pop();
    }

    if(st.peek()==-1) ans[idx] = idx-st.peek();
    else ans[idx] = idx- st.peek();

    st.push(idx);
   } 

   return ans;
 }

}
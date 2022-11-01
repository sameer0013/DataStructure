
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node){
    // write your code here
    int count =0;
    for(Node child: node.children){
      count += size(child);
    }
    return count+1;
  }

  public static int max(Node node){
    int res = Integer.MIN_VALUE;
    for(Node child: node.children){
        res = Math.max(res, max(child));
    }
    return Math.max(res,node.data);
  }
  public static void main(String[] args) throws Exception {
    try (Scanner scn = new Scanner(System.in)) {
        int n = scn.nextInt();
        int [] ar = new int[n];
        for(int i =0;i<n;i++){
            ar[i]=scn.nextInt();
        }

        Node root = construct(ar);
        int sz = max(root);
        System.out.println(sz);
        // display(root);
    }
  }

}

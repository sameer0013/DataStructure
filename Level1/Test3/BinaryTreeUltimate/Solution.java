import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        System.out.println("Node created");
        this.data = data;
    }

    Node(int data , Node left , Node right){
        this(data);
        this.left = left;
        this.right = right;
    }
}
class BT{
    Node root; 
    BT(Integer inp[]){
        System.out.println("Constructing your binary Tree");
        root = construct(inp);
    }
    private static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.state = state;
            this.node = node;
        }
    }
    private static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
    }
    public void display(){
        display(root);
    }
    public int size(){
        return size(root);
    }
    public int sum(){
        return sum(root);
    }
    public int max(){
        return max(root);
    }
    public int min(){
        return min(root);
    }
    public int height(){
        return height(root);
    }
    public boolean find(int data){
        return find(root,data);
    }
    public ArrayList<Integer> nodeToRootPath(int data){
        return nodeToRootPath(root,data);
    }
    private void display(Node node) {
        // code for displaying binary tree
        if (node == null) {
            return;
         }
        
        String str ="";
        str += node.left!=null?node.left.data+"":".";
        str += " <- "+node.data+" -> ";
        str += node.right!=null? node.right.data+"":".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    private int size(Node node) {
        // code for finding size of binary tree
        if(node == null) return 0;
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize+rsize+1;
    }
  
    private int sum(Node node) {
        // code for finding sum of binary tree
        if(node == null) return 0;
        
        int lsum = sum(node.left);
        int rsum = sum(node.right);
         
        return lsum+rsum+node.data;
    }
  
    private int max(Node node) {
        // code for finding max of binary tree
        if(node == null) return Integer.MIN_VALUE;
        
        int lmax = max(node.left);
        int rmax = max(node.right);
        
        return Math.max(lmax,Math.max(node.data,rmax));
    }
    private int min(Node node) {
        // code for finding min of binary tree
        if(node == null) return Integer.MAX_VALUE;
        
        int lmin = min(node.left);
        int rmin = min(node.right);
        
        return Math.min(lmin,Math.min(node.data,rmin));
        
    }
    
    private int height(Node node) {
        // code for finding height of binary tree
        if(node == null) return -1;
        int lht = height(node.left);
        int rht = height(node.right);
        
        return Math.max(lht,rht)+1;
    }

    private boolean find(Node node, int data){
        // code for finding data in a binary tree
        if(node == null) return false;
        
        
        if(node.data == data) return true;
        
        if(find(node.left,data)){
            return true;
        }
        if(find(node.right,data)){
            return true;
        }
        
        return false;
    }
    
    private ArrayList<Integer> nodeToRootPath(Node node, int data){
        // code for nodeToRootPath in a binary tree
        if(node == null) return new ArrayList<>();
        
        
        if(node.data == data) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(node.data);
            return ans;
        }
        
        ArrayList<Integer> lres = nodeToRootPath(node.left,data);
        
        if(lres.size()!=0){
            lres.add(node.data);
            return lres;
        }
        
        ArrayList<Integer> rres = nodeToRootPath(node.right,data);
        if(rres.size()!=0){
            rres.add(node.data);
            return rres;
        }
        
        return new ArrayList<>();
        
    }

}

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        int data = Integer.parseInt(br.readLine());
        BT bt = new BT(arr);

        bt.display();
        System.out.println("Size " + bt.size());
        System.out.println("Sum "+bt.sum());
        System.out.println("Max "+bt.max());
        System.out.println("Min "+bt.min());
        System.out.println("Height "+bt.height());

        boolean found = bt.find(data);
        System.out.println(found);

        ArrayList<Integer> path = bt.nodeToRootPath(data);
        System.out.println(path);
    }
}
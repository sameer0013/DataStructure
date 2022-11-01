import java.util.ArrayList;
import java.util.Stack;
public class Main{
    static class Node{
        int data;
        ArrayList<Node> children;

        Node(int val){
            data = val;
            children = new ArrayList<>();
        }

    }
    public static Node construct(Integer[] arr){
        Stack<Node> st = new Stack<>();

        Node root = new Node(arr[0]);
        st.push(root); // root node 

        int idx =1;
        while(idx<arr.length){
            
            Integer val =arr[idx]; //Integer add null value to but not int 
            if(val== null){
                st.pop();
            }else{
                Node node = new Node(val);
                Node par = st.peek();
                par.children.add(node);
                st.push(node);
            }
            idx++;
        }

        return root;
    }
    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node i : node.children){
            System.out.print(i.data+" ");
        }
        System.out.println(".");
        // int idx =0;
        // if(idx == node.children.size()) return;
        // while(idx<node.children.size()){
        //     display(node.children.get(idx));
        //     idx++;
        // }
        for(Node child:node.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        Integer [] arr = {10,20,50,null,60,null,null,30,70,90,null,100,null,110,null,null,null,40,80,null,null,null};
        Node root = construct(arr);
        display(root);

    }
}
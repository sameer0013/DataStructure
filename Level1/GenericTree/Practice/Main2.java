import java.util.*;
public class Main2 {

    static class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data =data;
            children = new ArrayList<>();
        }


    }

    public static Node construct(Integer[] arr){
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        int idx =1;
        st.push(root);
        while(idx<arr.length){
            Node node = st.peek();
            if(arr[idx]!=null){
                Node child = new Node(arr[idx]);
                node.children.add(child);
                st.push(child);
                
            }else{
                st.pop();
            }

            idx++;
        }

        return root;
    }
    
    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node child : node.children){
            System.out.print(child.data+" , ");
        }
        System.out.println(" .");

        for(Node child : node.children){
            display(child);
        }

    }

    public static int size(Node node){

        int ht =0;
        for(Node child : node.children){
            ht += size(child);
        }

        return ht+1;
    }

    public static int max(Node node){
        int max =Integer.MIN_VALUE;

        for(Node child : node.children){
            max = Math.max(child.data,Math.max(max(child),max));
        }

        return Math.max(max,node.data);
    }

    public static int height(Node node){
        int ht =-1;
        for(Node child : node.children){
            ht = Math.max(height(child),ht);
        }
        return ht+1;
    }

    public static void traversal(Node node){
        System.out.println("Node pre "+node.data);
        for(Node child :node.children){
            System.out.println("Edge pre "+node.data+"--"+child.data);
            traversal(child);
            System.out.println("Edge Post "+child.data+"--"+node.data);
        }

        System.out.println("Node Post "+node.data);
    }
    public static void main(String[] args) {
        Integer [] arr= {25,20,null,30,50,null,60,null,null,40,null,null};

        Node root =construct(arr);
        // display(root);
        // System.out.println(size(root));

        // System.out.println(max(root));

        // System.out.println(height(root));

        traversal(root);

    }
}

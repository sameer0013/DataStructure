/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.*;

class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()!=0){
            int size =q.size();
            Node tmp = null;
            while(size!=0){
                Node node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                if(tmp==null){
                    tmp = node;
                }else {
                    tmp.next=node;
                    tmp=node;
                }
                size--;
            }
            
        }
        return root;
    }
}
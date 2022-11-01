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

class Solution2{
    //this approach is only for perfect tree
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
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        
        Node ptr = root;
        
        while(ptr.left!=null){
            Node node = ptr;
            while(node!=null){
                node.left.next = node.right;
                
                if(node.next!=null)
                    node.right.next = node.next.left;
                
                node = node.next;
            }
            
            ptr = ptr.left;
        }
        return root;
    }
}

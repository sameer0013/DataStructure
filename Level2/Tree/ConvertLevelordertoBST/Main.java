//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        ArrayList<Integer> list = new ArrayList<>();
        for(int vl:arr){
            list.add(vl);
        }
        return buildTree(list);
    }
    
    private Node buildTree(ArrayList<Integer> levelorder){
        if(levelorder.size()==0) return null;
        int rval = levelorder.get(0);
        Node root = new Node(rval);
        if(levelorder.size()==1) return root;
        
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> larger = new ArrayList<>();
        
        for(int i=1;i<levelorder.size();i++){
            int val = levelorder.get(i);
            if(val<rval) smaller.add(val);
            else larger.add(val);
        }
        
        root.left= buildTree(smaller);
        root.right = buildTree(larger);
        return root;
    }
}
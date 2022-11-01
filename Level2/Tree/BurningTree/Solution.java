package BurningTree;

//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    private static int height(Node node){
        if(node==null){
            return 0;
        }
        return Math.max(height(node.left),height(node.right))+1;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        ArrayList<Node> path = nodeToRoot(root,target);
        if(path == null) return 0;
        int time=0;
        for(int i=0;i<path.size();i++){
            Node node = path.get(i);
            if(i==0){
                time = height(node)-1;
            }else{
                Node cnode = path.get(i-1);
                if(cnode == node.left){
                    time = Math.max(time,i+height(node.right));
                }else{
                    time = Math.max(time,i+height(node.left));
                }
            }
        }
        return time;
    }
    
    private static ArrayList<Node> nodeToRoot(Node root,int target){
        ArrayList<Node> ans = new ArrayList<>();
        if(root== null){
            return ans;
        }
        if(root.data==target){
            ans.add(root);
            return ans;
        }
        
        ArrayList<Node> lres = nodeToRoot(root.left,target);
        if(lres.size()!=0){
            lres.add(root);
            return lres;
        }
        
        ArrayList<Node> rres = nodeToRoot(root.right,target);
        if(rres.size()!=0){
            rres.add(root);
            return rres;
        }
        return ans;
    }
}

//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node left, right;
        
        Node(int item)
        {
            data = item;
            left = right = null;
        }    
            public void setLeft(Node left) 
        {
            this.left = left;
        }
      
        public void setRight(Node right) 
        {
            this.right = right;
        }
            
        
    }
    
    
    class ConstructBT
    {
        Node root;
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                
                int inord[] = new int[n];
                int level[] = new int[n];
                for(int i = 0; i < n; i++)
                    inord[i] = sc.nextInt();
                    
                for(int i = 0; i < n; i++)
                     level[i] = sc.nextInt();
                     
                GfG g = new GfG();
                Node node =  g.buildTree(inord, level);
                printPreOrder(node);
                System.out.println();
                
                
            }
        }
        
       static void printPreOrder(Node node)
       {
           if(node == null)
              return;
              
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
       }
    }
    
    // } Driver Code Ends
    
    
    /*Please note that it's Function problem i.e.
    you need to write your solution in the form of Function(s) only.
    Driver Code to call/invoke your function is mentioned above.*/
    
    /*Complete the function below*/
    class GfG
    {
        Node buildTree(int inorder[], int levelorder[])
        {
            //your code here
            ArrayList<Integer> list = new ArrayList<>();
            for(int vl:levelorder){
                list.add(vl);
            }
            return buildTree(inorder,list,0,inorder.length-1);
        }
        
        Node buildTree(int[] inorder,ArrayList<Integer> levelorder,int left,int right){
            if(levelorder.size()==0) return null;
            int rval = levelorder.get(0);
            Node root = new Node(rval);
            
            if(levelorder.size()==1) return root;
            
            int idx=left;
            HashSet<Integer> hs = new HashSet<>();
            while(inorder[idx]!=rval) hs.add(inorder[idx++]);
            
            ArrayList<Integer> leftlevelorder = new ArrayList<Integer>();
            ArrayList<Integer> rightlevelorder = new ArrayList<Integer>();
            
            for(int i=1;i<levelorder.size();i++){
                int vl = levelorder.get(i);
                if(hs.contains(vl)){
                    leftlevelorder.add(vl);
                }else{
                    rightlevelorder.add(vl);
                }
            }
            
            root.left = buildTree(inorder,leftlevelorder,left,idx-1);
            root.right = buildTree(inorder,rightlevelorder,idx+1,right);
            return root;
        }
        
       
    }
    
    
    
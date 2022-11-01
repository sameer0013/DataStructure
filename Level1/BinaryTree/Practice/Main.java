import java.util.*;
public class Main{

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left=null;
            this.right = null;
        }
    }

    static class Pair{
        Node node;
        int state;
        Pair(Node node){
            this.node=node;
            this.state=0;
        }
    }
    
    public static Node construct(Integer[] arr){
        Stack<Pair> st = new Stack<>();
        Node node = new Node(arr[0]);
        st.push(new Pair(node));
        int idx=1;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==0){
                Integer val = arr[idx];
                if(val!=null){
                    Node child = new Node(val);
                    top.node.left=child;
                    st.push(new Pair(child));
                }
                idx++;
                top.state++;
            }else if(top.state==1){
                Integer val = arr[idx];
                if(val !=null){
                    Node child = new Node(val);
                    top.node.right=child;
                    st.push(new Pair(child));
                }
                idx++;
                top.state++;
            }else if(top.state==2){
                st.pop();
            }

        }
        return node;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        System.out.println((node.left==null?".":node.left.data)+"<-"+node.data+"->"+(node.right==null?".":node.right.data));
        display(node.left);
        display(node.right);
    }
    
    public static int size(Node node){
        if(node ==null) return 0;
        int lsize = size(node.left);
        int rsize= size(node.right);
        return lsize+rsize+1;
    }
    
    public static int max(Node node){
        if (node == null) return 0;
        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(Math.max(lmax,rmax),node.data);
    }
    
    public static int sum(Node node){
        if( node == null) return 0;
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return rsum+lsum+node.data;
    }
    
    public static int height(Node node){
        if(node == null) return -1;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
    
    public static void levelOrderTraversal(Node node){
        Queue<Node> mqt = new ArrayDeque<>();
        Queue<Node> hqt = new ArrayDeque<>();
        mqt.add(node);
        while(mqt.size()>0){
            Node val = mqt.remove();
            System.out.print(val.data+" ");
            if(val.left!=null) hqt.add(val.left);
            if(val.right!=null) hqt.add(val.right);
            if(mqt.size()==0){
                mqt=hqt;
                hqt = new ArrayDeque<>();
                System.out.println();
            }

        }
    }
    
    public static boolean find(Node node,int data){
        if(node == null) return false;
        if(node.data==data) return true;

        boolean lres = find(node.left,data);
        if(lres) return lres;
        boolean rres = find(node.right,data);
        if(rres) return rres;

        return false;


    }
    
    public static ArrayList<Integer> nodeToRootpath(Node node, int data){
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null) return list;
        if(node.data == data) {
            list.add(node.data);
            return list;
        } 

        ArrayList<Integer> llist = nodeToRootpath(node.left, data);
        if(llist.size()>0){
            llist.add(node.data);
            return llist;
        }
        ArrayList<Integer> rlist = nodeToRootpath(node.right, data);
        if(rlist.size()>0){
            rlist.add(node.data);
            return rlist;
        }
        return list;

    }

    public static void printKlevelsDown(Node node,int k){
        if(node==null) return;
        if(k==0){
            System.out.print(node.data+" ");
            return;
        }
        printKlevelsDown(node.left,k-1);
        printKlevelsDown(node.right,k-1);
    }

    public static void singleChildNode(Node node,Node par){
        if(node==null) return;
        
            //Apporach 1st with parent
        // if(par != null){
        //     if(node==par.left&&par.right==null){
        //         System.out.println(node.data);
        //     }
        //     else if(node==par.right && par.left==null){
        //         System.out.println(node.data);
        //     }
        // }
        // singleChildNode(node.left, node);
        // singleChildNode(node.right, par);

            // Apporach 2nd without parent
        if(node.left!=null&&node.right==null){
            System.out.println(node.left.data);
        }
        else if(node.left==null && node.right !=null){
            System.out.println(node.right.data);
        }
        singleChildNode(node.left, par);
        singleChildNode(node.right, par);
    }

    public static Node removeLeaf(Node node){
        if(node==null) return null;
        if(node.left==null && node.right == null){
            return null;
        }
        Node n1 = removeLeaf(node.left);
        node.left =n1;
        Node n2 = removeLeaf(node.right);
        node.right=n2;
        return node;

    }
    public static void main(String[] args){

        Integer [] arr={10,20,40,70,null,null,80,null,null,null,30,60,90,100,null,null,null,null,50,null,null};
        Node root=construct(arr);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(max(root));
        // System.out.println(sum(root));
        // System.out.println(height(root));
        levelOrderTraversal(root);
        // System.out.println(find(root,50));
        // ArrayList<Integer>list=nodeToRootpath(root, 100);
        // System.out.println(list);
        // System.out.println("3 levels are: " );
        // printKlevelsDown(root,3);

        // System.out.println(" Single childs are :");
        // singleChildNode(root, null);

        display(root);
        System.out.println("After Leaf removal: ");
        removeLeaf(root);
        display(root);
    }
}
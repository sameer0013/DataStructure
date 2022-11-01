import java.util.*;

public class Main{
    static class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data=data;
            children= new ArrayList<>();
        }
    }

    public static Node construct(Integer[] arr){
        Stack<Node> st= new Stack<>();
        Node node = new Node(arr[0]);
        st.push(node);
        int idx=1;
        while(idx<arr.length){
            if(arr[idx]==null){
                st.pop();
            }else{
                Node child = new Node(arr[idx]);
                st.peek().children.add(child);
                st.push(child);
            }
            idx++;
        }
        return node;
    }
    
    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node n : node.children){
            System.out.print(n.data+" ");
        }
        System.out.println(".");
        for(Node n :node.children){
            display(n);
        }
    }

    public static int size(Node node){
        int res=0;
        for(Node child:node.children){
            int rres = size(child);
            res += rres;
        }
        return res+1;
    }
    
    public static int maximum(Node node){
        int res =Integer.MIN_VALUE;
        for(Node child : node.children){
            int rres=Math.max(maximum(child),Math.max(child.data,res));
            res=rres;
        }
        return Math.max(node.data,res);
    }
   
    public static int height(Node node){
        int res =-1;
        for(Node child:node.children){
            int rres = Math.max(height(child),res);
            res = rres;
        }
        return res+1;
    }
    
    public static void traversal(Node node){
        System.out.println("Node pre "+node.data);
        for(Node child:node.children){
            System.out.println("Edge Pre "+node.data+"->"+child.data);
            traversal(child);
            System.out.println("Edge Post "+child.data+"->"+node.data);
        }
        System.out.println("Node post "+node.data);;
    }

    public static void printLevelwise(Node node){
        Queue<Node> qt = new ArrayDeque<>();
        qt.add(node);
        while(qt.size()>0){
            Node val = qt.remove();
            System.out.print(val.data+" ");
            for(Node child:val.children){
                qt.add(child);
            }

        }
        
    }
    
    public static void printLevelLinewise(Node node){
        Queue<Node> mqt = new ArrayDeque<>();
        Queue<Node> hqt = new ArrayDeque<>();
        mqt.add(node);
        while(mqt.size()>0){
            Node val = mqt.remove();
            System.out.print(val.data+" ");
            for(Node child:val.children){
                hqt.add(child);
            }
            if(mqt.size()==0){
                mqt=hqt;
                hqt= new ArrayDeque<>();
                System.out.println();
            }
        }

    }
    
    public static void printLevelZigZag(Node node){
        Stack<Node> mst = new Stack<>();
        Stack<Node> hst = new Stack<>();

        mst.push(node);
        int level =0;
        while(mst.size()>0){
            Node val = mst.pop();
            System.out.print(val.data+" ");
            if(level%2==0)
            {

                for(int i=0;i<val.children.size();i++){
                    Node child = val.children.get(i);
                    hst.add(child);
                }
            }else{
                for(int i=val.children.size()-1;i>=0;i--){
                    Node child = val.children.get(i);
                    hst.add(child);
                }
            }
            if(mst.size()==0){
                mst=hst;
                hst= new Stack<>();
                System.out.println();
                level++;
            }
           
        }


    }

    public static boolean find(Node node,int k){
        if(node.data == k){
            return true;
        }
        boolean res = false;
        for(Node child:node.children){
             res= find(child,k);
             if(res) return res;
        }
        return res;
    }

    public static ArrayList<Integer> nodetorootpath(Node node,int n){
        if(node.data ==n){
            ArrayList<Integer>list=new ArrayList<>();
            list.add(n);
            return list;
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(Node child: node.children){
            list=nodetorootpath(child, n);
            if(list.size()!=0){
                list.add(node.data);
                return list;
            }
            
        }
        return list;
    }

    public static int lca(Node node, int d1,int d2){
        ArrayList<Integer> n1 = nodetorootpath(node, d1);
        ArrayList<Integer> n2 = nodetorootpath(node, d2);
        int idx1 = n1.size()-1;
        int idx2 = n2.size()-1;
        while((idx1>=0&&idx2>=0)){
            if(n1.get(idx1)==n2.get(idx2)){
                idx1--;
                idx2--;
            }else{
                break;
            }
        }
        return n1.get(idx1+1);
    }

    public static void removeLeaf(Node node){
        if(node.children.size()==0){
            return ;
        }

        for(int idx=node.children.size()-1;idx>=0;idx--){
            Node child = node.children.get(idx);
            if(child.children.size()==0){
                node.children.remove(idx);
            }
        }
        for(Node child :node.children){
            removeLeaf(child);
        }
    }

    public static Node getTailNode(Node node){
        while(node.children.size()!=0){
            node = node.children.get(0);
        }
        return node;
    }
    
    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }
        while(node.children.size()>1){
            Node lc = node.children.get(node.children.size()-1);
            Node slc = node.children.get(node.children.size()-2);
            node.children.remove(node.children.size()-1);
            Node tailnode = getTailNode(slc);
            tailnode.children.add(lc);
        }
    }
    
    public static int distance(Node node,int d1,int d2){
        ArrayList<Integer> path1 =nodetorootpath(node, d1);
        ArrayList<Integer> path2 =nodetorootpath(node, d2);

        int i =path1.size()-1;
        int j = path2.size()-1;
        while(i>=0&&j>=0){
            if(path1.get(i)==path2.get(j)){
                i--;
                j--;
            }else{
                break;
            }

        }
        i=i+1;
        j=j+1;
        return i+j;
    }
    public static void main(String[] args){
        Integer arr[]={10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = construct(arr);
        // display(root);
        // System.out.println("size of this Genric tree : "+ size(root));
        // System.out.println("Maximum of this GT : "+ maximum(root));
        // System.out.println("Height of this GT : "+ height(root));
        // traversal(root);
        // printLevelwise(root);
        // printLevelLinewise(root);
        // printLevelZigZag(root);
        // System.out.println(find(root, 110));
        // ArrayList<Integer>list =nodetorootpath(root, 110);
        // System.out.println(list);
        // System.out.println(lca(root,110,120));
        // removeLeaf(root);
        // display(root);
        // linearize(root);
        display(root);
        System.out.println(distance(root, 20, 30));

    }
}
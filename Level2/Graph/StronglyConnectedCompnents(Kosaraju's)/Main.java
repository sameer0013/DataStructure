//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    void dsa(ArrayList<ArrayList<Integer>> adj,int vtx,Stack<Integer> st , boolean vis[]){
        vis[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for(Integer e: nbrs){
            if(vis[e]==false) dsa(adj,e,st,vis);
        }
        
        st.push(vtx);
    }
    void dsa(ArrayList<ArrayList<Integer>> adj,int vtx , boolean vis[]){
        vis[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for(Integer e: nbrs){
            if(vis[e]==false) dsa(adj,e,vis);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //create stack
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dsa(adj,i,st,vis);
            }
        }
        
        //reverse graph
        ArrayList<ArrayList<Integer>> revadj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revadj.add(new ArrayList<Integer>());
        }
        
        for(int vtx=0;vtx<V;vtx++){
            ArrayList<Integer> nbrs = adj.get(vtx);
            for(Integer nbr : nbrs){
                revadj.get(nbr).add(vtx);
            }
        }
        
        //find total components
        vis = new boolean[V];
        int count=0;
        while(st.size()>0){
            int vtx = st.pop();
            if(vis[vtx]==false){
                count++;
                dsa(revadj,vtx,vis);
            }
        }
        return count;
    }
}

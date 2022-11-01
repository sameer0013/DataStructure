import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      System.out.println(isGraphConnected(graph));
   }
   public static boolean isGraphConnected(ArrayList<Edge>[] graph){
       return (gcc(graph).size()==1);
   }
   public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
       ArrayList<ArrayList<Integer>> res= new ArrayList<>();
       boolean vis[] = new boolean[graph.length];
       
       for(int vt =0;vt<vis.length;vt++){
            if(!vis[vt]){
                ArrayList<Integer> comps = new ArrayList<>();
                dfs(graph,vt,vis,comps);
                res.add(comps);
            }        
       }
       return res;
   }
   
   public static void dfs(ArrayList<Edge>[] graph,int vtx,boolean[] vis, ArrayList<Integer> comps){
       vis[vtx] = true;
       comps.add(vtx);
       for(Edge e: graph[vtx]){
           if(!vis[e.nbr]){
               dfs(graph,e.nbr,vis,comps);
           }
       }
   }
}
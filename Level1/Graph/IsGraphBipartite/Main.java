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
      System.out.println(isBipartite(graph));
   }


   public static class Pair{
      int src;
      int level;
      Pair(int src,int lvl){
         this.src=src;
         this.level=lvl;
      }
   }
   public static boolean isBipartite(ArrayList<Edge>[] graph){
      int[] vis = new int[graph.length];
      
      for(int i =0;i<vis.length;i++){
         if(vis[i]==0){
            boolean res = iscompBipartite(graph,i,vis);
            if(!res) return false;
         }
      }
      return true;
   }

   public static boolean iscompBipartite(ArrayList<Edge>[] graph,int src,int []vis){
      Queue<Pair> qt = new ArrayDeque<>();

      qt.add(new Pair(src,1));

      while(qt.size()>0){
        Pair p = qt.remove();
        if(vis[p.src]==0){
           vis[p.src]=p.level;
           for(Edge e : graph[p.src]){
              if(vis[e.nbr]==0){
               qt.add(new Pair(e.nbr,p.level+1));
              }
              
           }

        }else{
           if(vis[p.src]!=p.level){
              return false;
           }
        }
      }


      return true;

   }
}
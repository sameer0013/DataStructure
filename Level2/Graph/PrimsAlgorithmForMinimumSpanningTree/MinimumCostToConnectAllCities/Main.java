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
      MST(graph);
   }
   
   public static class Pair implements Comparable<Pair>{
       int vtx,par,wt;
       Pair(int vtx,int par,int wt){
           this.vtx= vtx;
           this.par = par;
           this.wt = wt;
       }
       
       public int compareTo(Pair o){
           return this.wt - o.wt;
       }
   }
   public static void MST(ArrayList<Edge>[] graph){
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(0,-1,0));
       boolean vis[]= new boolean[graph.length];
       int cost=0;
       while(pq.size()>0){
           Pair rem = pq.remove();
           if(!vis[rem.vtx]){
               vis[rem.vtx] = true;
               
               cost += rem.wt;
               for(Edge e: graph[rem.vtx]){
                   if(!vis[e.nbr])
                    pq.add(new Pair(e.nbr,rem.vtx,e.wt));
               }
           }
           
           
       }
       System.out.println(cost);
       
   }

}
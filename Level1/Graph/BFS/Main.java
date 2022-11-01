package BFS;

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      bfs(graph,src,new boolean[graph.length],new ArrayDeque<Pair>());
   }

   static class Pair{
      int src;
      String psf;
      Pair(int src,String psf){
         this.src=src;this.psf=psf;
      }
   }

   public static void bfs(ArrayList<Edge>[] graph,int src,boolean[] vis,Queue<Pair> qt){
      qt.add(new Pair(src,""+src));
      while(qt.size()>0){
         Pair p =qt.remove();
         if(vis[p.src]==false){
            vis[p.src]=true;
            System.out.println(p.src+"@"+p.psf);
            for(Edge e:graph[p.src]){
               qt.add(new Pair(e.nbr,p.psf+e.nbr));
            }
         }
      }
      

   }
}

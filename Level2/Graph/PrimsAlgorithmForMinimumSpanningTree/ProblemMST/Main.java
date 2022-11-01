import java.util.*;
import java.lang.*;

class Main
{
	public static class Edge{
		int src,nbr,wt;
		Edge(int src,int nbr,int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static class Pair implements Comparable<Pair>{
		int vtx,par,wt;
		Pair(int vtx,int par,int wt){
			this.vtx = vtx;
			this.par = par;
			this.wt = wt;
		}
		public int compareTo(Pair o){
			return this.wt - o.wt;
		}
	}
	public static int MST(ArrayList<Edge>[] graph){
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[graph.length];
		int cost=0;
		pq.add(new Pair(1,-1,0));
		while(pq.size()>0){
			Pair rem = pq.remove();
			if(!vis[rem.vtx]){
                vis[rem.vtx] = true;
				cost += rem.wt;
				ArrayList<Edge> edges = graph[rem.vtx];
				for(Edge e: edges){
					pq.add(new Pair(e.nbr,rem.vtx,e.wt));
				}
			}
		}
		return cost;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
	
		Scanner scn = new Scanner(System.in);
		int nvtx = scn.nextInt();
		int edges = scn.nextInt();
		
		ArrayList<Edge>[] graph = new ArrayList[nvtx+1];
		for(int i=1;i<=nvtx;i++){
			graph[i] = new ArrayList<>();
		}
		while(edges-->0){
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			int wt = scn.nextInt();
			
			
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		System.out.println(MST(graph));
	}
	
	
}
import java.util.*;
import java.lang.*;

class Main
{
	private static class DSU{
		int[] par;
		int[] rank;
		DSU(int vtx){
			par = new int[vtx];
			rank = new int[vtx];
			for(int i=0;i<par.length;i++){
				par[i] = i;
				rank[i] =1;
			}
		}
		public int find(int x){
			if(x==par[x]){
				return x;
			}
			return par[x] = find(par[x]);
		}
		
		public void union(int x,int y){
			int xl = find(x);
			int yl = find(y);
			if(xl !=yl){
				if(rank[xl]>rank[yl]) par[yl] = xl;
				else if(rank[xl]<rank[yl]) par[xl] = yl;
				else{
					par[xl] = yl;
					rank[yl]++;
				}
			}
		}
		public boolean acyclic(int x,int y){
			return find(x) != find(y);
		}
	}
	
	private static class Pair implements Comparable<Pair>{
		int x,y,wt;
		Pair(int x,int y,int wt){
			this.x = x;
			this.y = y;
			this.wt = wt;
		}
		public int compareTo(Pair o){
			return this.wt - o.wt;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int nvtx = scn.nextInt();
		int edges = scn.nextInt();
		DSU dsu = new DSU(nvtx+1);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i=0;i<edges;i++){
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			int wt = scn.nextInt();
			pq.add(new Pair(v1,v2,wt));
			
		}
		
		int ans = krushkal(pq,dsu);
		System.out.println(ans);
	}
	public static int krushkal(PriorityQueue<Pair> pq,DSU dsu){
		int cost =0;
		while(pq.size()!=0){
			Pair rem = pq.remove();
			if(dsu.acyclic(rem.x,rem.y)){
				dsu.union(rem.x,rem.y);
				cost += rem.wt;
			}
		}
		return cost;
	} 
}
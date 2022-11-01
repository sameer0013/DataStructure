class Solution {
    class Pair implements Comparable<Pair>{
        int u,v,wt;
        Pair(int u,int v,int wt){
            this.u=u;
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
        public String toString(){
            return this.u+"->"+this.v+"="+this.wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0;i<points.length;i++){
            int[] x = points[i];
            for(int j=i+1;j<points.length;j++){
                int[] y = points[j];
                int wt = Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
                Pair p = new Pair(i,j,wt);
                // System.out.println(p);
                pq.add(p);
                
            }
        }
        int cost=0;
        int count=0;
        DSU dsu = new DSU(points.length);
        while(pq.size()>0 && count <=points.length-1){
            Pair rem = pq.remove();
            if(dsu.acylic(rem.u,rem.v)){
                dsu.union(rem.u,rem.v);
                cost += rem.wt;
                System.out.println(rem.wt);
                count++;
            }
            
        }
        return cost;
    }
    
    class DSU{
        private int par[];
        private int rank[];
        DSU(int vtx){
            this.par = new int[vtx];
            this.rank = new int[vtx];
            for(int i=0;i<par.length;i++){
                par[i] = i;
                rank[i] = 1;
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
            if(xl!=yl){
                if(rank[xl]>rank[yl]) par[yl] = xl;
                else if(rank[xl]<rank[yl]) par[xl] = yl;
                else{
                    par[xl]=yl;
                    rank[yl]++;
                }
            }
        }
        public boolean acylic(int x,int y){
            return find(x)!=find(y);
        }
    }
}
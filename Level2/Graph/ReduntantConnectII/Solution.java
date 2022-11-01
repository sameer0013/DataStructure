class Solution {
    class DSU{
        int[] par;
        int[] rank;
        DSU(int n){
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<par.length;i++){
                par[i]= i;
                rank[i]=1;
                
            }
        }
        public int find(int x){
            if(par[x]==x) return x;
            return par[x]=find(par[x]);
        }
        public boolean union(int x,int y){
            int xl = find(x);
            int yl = find(y);
            if(xl== yl) return true;
            else{
                if(rank[xl]>rank[yl]) par[yl] =xl;
                else if(rank[xl]<rank[yl]) par[xl] =yl;
                else{
                    par[xl] =yl;
                    rank[yl]++;
                }
            }
            return false;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length+1);
        int[] arr = new int[edges.length+1];
        Arrays.fill(arr,-1);
        int p1=-1,p2=-1;
        for(int i=0;i<edges.length;i++){
            int[] edge = edges[i];
            int v= edge[0];
            int u = edge[1];
            if(arr[u]==-1){
                arr[u]=i;
            }else{
                p1= arr[u];
                p2 = i;
                break;
                }
            
        }
        
        for(int i=0;i<edges.length;i++){
             int[] edge = edges[i];
            int v= edge[0];
            int u = edge[1];
            if(p2==i) continue;
            boolean flag = dsu.union(v,u);
            if(flag){
                if(p1==-1){
                    return edge;
                }else{
                    return edges[p1];
                }
            }
        }
        return edges[p2];
    }
}
import java.util.*;
class DSU{

    static int[] par;
    private int[] rank;
    DSU(int nvtx){
        par = new int[nvtx];
        rank = new int[nvtx];
        for(int i=0;i<nvtx;i++){
            par[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(x==par[x]){
            return x;
        }
        int leader = find(par[x]);
        par[x] = leader; //compression
        return leader;
    }
    public void union(int x , int y){
        int xl = find(x);
        int yl = find(y);

        if(xl!=yl){

            if(rank[xl]>rank[yl]) par[yl] =xl;
            else if(rank[xl]<rank[yl]) par[xl] =yl;
            else {
                par[xl] = yl;
                rank[yl]++;
            }

        }
    }
}

public class Main2{
    public static boolean isConnected(DSU dsu,int x,int y){
        return dsu.find(x)== dsu.find(y);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nvtx = scn.nextInt();
        int nedges = scn.nextInt();
        DSU dsu = new DSU(nvtx);
        for(int i=0;i<nedges;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            dsu.union(v1, v2);
        }
        int i=0;
        for(int vl:dsu.par){
            System.out.println(i++ +"->"+vl);
        }
        System.out.println(isConnected(dsu, 0, 5));
        System.out.println(isConnected(dsu, 2, 8));
    }
}
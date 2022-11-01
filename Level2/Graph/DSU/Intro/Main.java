import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nvtx = scn.nextInt();
        int[] par = new int[nvtx];
        int nedges = scn.nextInt();
        for(int i=0;i<par.length;i++){
            par[i]=i;
        }
        for(int i=0;i<nedges;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            union(v1,v2,par);
        }
        int i=0;
        for(int vl : par)
            System.out.println(i++ +"->"+vl);
    }
    
    public static void union(int x,int y,int[] par){
        int xl = find(x,par);
        int yl = find(y,par);
        if(xl != yl){
            par[xl] = yl;
        }
    }
    public static int find2(int x, int[] par){
        while(x!=par[x]){  //without stack space optimised
            x = par[x];
        }
        return x;
    }
    public static int find(int x, int[] par){
        if(x==par[x]){
            return x;
        }
        return find(par[x],par);
    }
}
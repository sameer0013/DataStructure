import java.util.*;

public class Main{

    public static class Edge{
        int vtx,nbr,wt;
        Edge(int vtx,int nbr,int wt){
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }
        public String toString(){
            return vtx+"-"+nbr+"@"+wt;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int city[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                city[i][j] = scn.nextInt();
            }
        }

        ArrayList<Edge>[] graph = new ArrayList[n+1];   
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<city.length;i++){
            for(int j=0;j<city[0].length;j++){
                if(i!=j && city[i][j]!=0){
                    graph[i+1].add(new Edge(i+1,j+1,city[i][j]));
                }
            }
        }   
        
    //    for(int i=1;i<=n;i++){
    //         for(Edge e: graph[i]){
    //             System.out.println(e);
    //         }
    //    }

    new Main().mst(graph);
    }
    public class  Pair implements Comparable<Pair>{
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
    public void mst(ArrayList<Edge>[] graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1,-1,0));
        boolean vis[] = new  boolean[graph.length];

        int cost =0;
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


//   //Input 1

    // 5
    // 0 1  2  3  4 
    // 1  0  5  0  7 
    // 2  5  0  6  0 
    // 3  0  6  0  0
    // 4  7  0  0  0 

// o/p -> 10
                       

     
//     // Input 2

    // 6
    // 0  1  1  100  0  0 
    // 1  0  1  0  0  0 
    // 1  1  0  0  0  0 
    // 100  0  0  0  2  2 
    // 0  0  0  2  0  2 
    // 0  0  0  2  2  0 

// o/p -> 106    
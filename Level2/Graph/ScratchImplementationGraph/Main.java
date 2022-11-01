import java.util.*;
public class Main{
    public static class Edge{
        int src, nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
        public String toString(){
            return src+"->"+nbr;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nvtx = scn.nextInt();
        int edges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[nvtx];
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<edges;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1,v2));

            graph[v2].add(new Edge(v2,v1));

        }

        System.out.println(Arrays.toString(graph));
    }
}
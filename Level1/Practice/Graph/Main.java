import java.util.*;

public class Main{
    public static class Edge{
        int src,nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }

    public static void displayGraphList(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            for(Edge e:graph[i]){
                System.out.println(e.src+" -> "+e.nbr);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(Edge e : graph[src]){
            if(vis[e.nbr]==false){
               boolean rres = hasPath(graph, e.nbr, dest, vis);
               return rres;
            }

        }
        return false;
    }

    public static void printAllPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis,String asf){
        if(src==dest){
            System.out.println(asf+src);
        }
        vis[src]=true;
        for(Edge e:graph[src]){
            if(vis[e.nbr]==false){
                printAllPath(graph, e.nbr, dest, vis, asf+src);
            }
        }
        vis[src]=false;

    }

    //   1ST METHOD OF CREATING GRAPH   //

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int nvertex =scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[nvertex];
        for(int i=0;i<nvertex;i++){
            graph[i]=new ArrayList<>();
        }
        int nedges=scn.nextInt();
        for(int i=1;i<=nedges;i++ ){
            int v1=scn.nextInt(),v2=scn.nextInt();
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        } 

        // displayGraphList(graph);

        System.out.println("find Path ?[y/n]");
        char ch = scn.next().charAt(0);

        if(ch=='y'){
            int src=scn.nextInt();
            int dest =scn.nextInt();
            boolean [] vis = new boolean[nvertex];
            System.out.println(hasPath(graph,src,dest,vis));
        }
        System.out.println("find All Path ?[y/n]");
        char cha = scn.next().charAt(0);

        if(cha=='y'){
            int src=scn.nextInt();
            int dest =scn.nextInt();
            printAllPath(graph, src, dest, new boolean[nvertex], "");
            
        }
    }


    //    2ND METHOD OF CREATING GRAPH   //

    // public static void main(String[] args) {
    //     Scanner scn = new Scanner(System.in);
    //     int nvertex=scn.nextInt();
    //     int[][] graph = new int[nvertex][nvertex];
    //     int nedges = scn.nextInt();
    //     for(int i=0;i<nedges;i++){
    //         int v1=scn.nextInt(),v2=scn.nextInt();
    //         graph[v1][v2]=1;
    //         graph[v2][v1]=1;
    //     }

    //     for(int i=0;i<nvertex;i++){
    //         for(int j=0;j<nvertex;j++){
    //             System.out.print(graph[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     displayGraphArray(graph);
    // }
    // public static void displayGraphArray(int[][] graph){
    //     for(int i=0;i<graph.length;i++){
    //         for(int j=0;j<graph[i].length;j++){
    //             if(graph[i][j]==1){
    //                 System.out.println(i+" -> "+j);
    //             }else{
                    
    //             }
                
    //         }
    //     }
    // }
}
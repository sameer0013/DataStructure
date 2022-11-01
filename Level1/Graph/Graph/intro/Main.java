package Graph.intro;
import java.util.*;

public class Main{

    public static class Edge{
        int src,nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int nvrtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[nvrtces];

        for(int i=0;i<nvrtces;i++){
            graph[i]= new ArrayList<>();
        }
        int nedge=scn.nextInt();
        for(int i=1;i<=nedge;i++){
            int v1 =scn.nextInt(),v2=scn.nextInt();
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        for(ArrayList<Edge> list:graph){
            for(Edge e:list){
                System.out.println(e.src+" -> "+e.nbr);
            }
        }
    }
}
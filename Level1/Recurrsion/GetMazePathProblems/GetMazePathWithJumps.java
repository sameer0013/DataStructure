package GetMazePathProblems;
import java.io.*;
import java.util.*;

public class GetMazePathWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr=scn.nextInt();
        int dc=scn.nextInt();
        ArrayList<String> res=getMazePaths(1,1,dr,dc);
        System.out.println(res);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc== dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(sr>dr||sc>dc){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        
        ArrayList<String> mylist = new ArrayList<>();
        for(int ms=1;ms<=dc-sc;ms++){
            ArrayList<String> hpath = getMazePaths(sr,sc+ms,dr,dc);
            for(String path : hpath){
                mylist.add("h"+ms+path);
            }

        }
        for(int ms=1;ms<=dr-sr;ms++){
            ArrayList<String> vpath = getMazePaths(sr+ms,sc,dr,dc);
            for(String path : vpath){
                mylist.add("v"+ms+path);
            }    
        }
        for(int ms=1;ms<=dc-sc && ms<=dr-sr;ms++){
            ArrayList<String> dpath = getMazePaths(sr+ms,sc+ms,dr,dc);

            for(String path : dpath){
                mylist.add("d"+ms+path);
            }
        }

        return mylist;
    }

}
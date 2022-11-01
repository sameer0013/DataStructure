import java.io.*;
import java.util.*;

// reactive approach
public class GetMazePath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        ArrayList<String> res= getMazePaths(0,0,dr-1,dc-1);
        System.out.println(res);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr&&sc==dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if(sr>dr || sc>dc){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> mylist = new ArrayList<>();

        ArrayList<String> hpath = getMazePaths(sr,sc+1,dr,dc);
        ArrayList<String> vpath = getMazePaths(sr+1,sc,dr,dc);

        for(String  path: hpath){
            mylist.add("h"+path);
        }
        for(String  path: vpath){
            mylist.add("v"+path);
        }

        return mylist;
    }

}
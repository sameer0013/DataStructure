import java.io.*;
import java.util.*;

public class  ReactiveApproachGetStairPath{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> res=getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        if(n<0){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> mylist = new ArrayList<>();
        ArrayList<String> path1len = getStairPaths(n-1);
        ArrayList<String> path2len = getStairPaths(n-2);
        ArrayList<String> path3len = getStairPaths(n-3);

        for(String path : path1len){
            mylist.add(1+path);
        }
        for(String path : path2len){
            mylist.add(2+path);
        }
        for(String path : path3len){
            mylist.add(3+path);
        }

        return mylist;
        
    }

}
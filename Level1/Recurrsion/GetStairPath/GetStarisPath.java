import java.io.*;
import java.util.*;

public class GetStarisPath 
{

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
        // Proactive approach for getstair path better than reactive one
        ArrayList<String> mylist = new ArrayList<>();
        if(n>=1){ //1 len
            ArrayList<String> paths = getStairPaths(n-1);
            for(String path : paths){
                mylist.add(1+path);
            }
        }
        if(n>=2){// 2 len
            ArrayList<String> paths = getStairPaths(n-2);
            for(String path : paths){
                mylist.add(2+path);
            }
        }
        if(n>=3){//3 len
            ArrayList<String> paths = getStairPaths(n-3);
            for(String path : paths){
                mylist.add(3+path);
            }
        }
        return mylist;
    }

}

import java.io.*;
import java.util.*;

public class GetSubsequences 
{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        ArrayList<String> list=gss(str);
        System.out.println(list);
    }

    public static ArrayList<String> gss(String s) {
        if(s.length()==0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
            
           }

        String res=s.substring(1);
        char ch= s.charAt(0);
        ArrayList<String> rres= gss(res);

        ArrayList<String> mylist = new ArrayList<>();

        //exclude ch
        for(String str: rres){
            mylist.add(str);
        }   

        //include ch
        for(String str: rres){
            mylist.add(ch+str);
        }
        return mylist;
    }

}

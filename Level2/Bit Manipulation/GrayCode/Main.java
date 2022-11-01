package GrayCode;

import java.util.*;
 
 public class Main {
 
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
         
     }
     public static List<Integer> grayCode(int n){
       
         List<Integer> ans = new ArrayList<>();
         if(n==0){
             ans.add(0);
             return ans;
         }
         ArrayList<String> res = fun(n);
         for(String s:res){
             ans.add(Integer.parseInt(s,2));
         }
         return ans;
     }
     public static ArrayList<String> fun(int n){
         
         if(n==0){
             ArrayList<String> res = new ArrayList<>();
             res.add("");
             return  res;
         }
         ArrayList<String> rres = fun(n-1);
         ArrayList<String> mylist = new ArrayList<>();
         for(String vl:rres){
             mylist.add("0"+vl);
         }
         for(int i=rres.size()-1;i>=0;i--){
             mylist.add("1"+rres.get(i));
         }
         return mylist;
     }
 }

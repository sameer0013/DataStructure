import java.io.*;

import java.util.*;

public class Main {

  public static void getcommonElement(int[] arr1,int[] arr2){
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int i =0;i<arr1.length;i++){
      if(hm.containsKey(arr1[i])){
        hm.put(arr1[i],hm.get(arr1[i])+1);
      }
      else{
        hm.put(arr1[i],1);
      }

    }
    //System.out.println(hm);
    for(int i =0;i<arr2.length;i++){
      if(hm.containsKey(arr2[i])&&hm.get(arr2[i])>0){
        System.out.println(arr2[i]);
        if(hm.get(arr2[i])>1){
          hm.put(arr2[i],hm.get(arr2[i])-1);
        }else{
          hm.remove(arr2[i]);
        }
      }
      
    }
  }
  public static void main(String[] args) throws Exception {
	  //Write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1=new int[n1];
    for(int i=0;i<n1;i++){
      arr1[i]=scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] arr2=new int[n2];
    for(int i=0;i<n2;i++){
      arr2[i]=scn.nextInt();
    }

    getcommonElement(arr1,arr2);
    
  }

}
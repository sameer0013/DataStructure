import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    HashMap<String,HashSet<String>> hm = new HashMap<>();
    String ceo="";
    for(int i=0;i<n;i++){
      String employee =scn.next();
      String manager = scn.next();
      if(employee.equals(manager)){
        ceo=manager;
        continue;
      }
      if(hm.containsKey(manager)){
        HashSet<String> hs = hm.get(manager);
        hs.add(employee);
        hm.put(manager,hs);
      }else{
        HashSet<String> hs= new HashSet<>();
        hs.add(employee);
        hm.put(manager,hs);
      }
    }

    // System.out.println(hm);

    HashMap<String,Integer> ans = new HashMap<>();

    traverse(hm,ceo,ans);

    for(String manager:ans.keySet()){
      int manages = ans.get(manager);
      System.out.println(manager+" "+manages);
    }



  }

  public static int traverse(HashMap<String,HashSet<String>> tree,String manager,HashMap<String,Integer> ans){
    HashSet<String> emplist = tree.get(manager);
    if(emplist==null){
      ans.put(manager,0);
      return 1;
    }
    int size=0;
    for(String emp : emplist){
      size += traverse(tree,emp,ans);
    }
    ans.put(manager,size);
    return size+1;
  }
}
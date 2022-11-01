import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }
  
  public static String sorted(String str){
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      
      return new String(arr) ;
  }

  public static int makeNum(String s,HashMap<Character, Integer> charIntMap){
      String str = "";
      for(int i =0;i<s.length();i++){
          char ch = s.charAt(i);
          str += charIntMap.get(ch);
          
      }
      return Integer.parseInt(str);
  }
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
							      
	    // write your code here
	    if(idx == unique.length()){
	        int ns1 = makeNum(s1,charIntMap);
	        int ns2 = makeNum(s2,charIntMap);
	        int ns3 = makeNum(s3,charIntMap);
            unique= sorted(unique);
	        if(ns1+ns2==ns3){
	            for(int i=0;i<unique.length();i++){
	                 char ch = unique.charAt(i);
	                System.out.print(ch+"-"+charIntMap.get(ch)+" ");
	            }
	            System.out.println();
	        }
	        return;
	    }
	    char ch = unique.charAt(idx);
	    for(int i=0;i<10;i++){
	        if(!usedNumbers[i]){
	            usedNumbers[i]=true;
	            charIntMap.put(ch,i);
	            solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
	            usedNumbers[i]=false;
	        }
	    }
	    
  }

}

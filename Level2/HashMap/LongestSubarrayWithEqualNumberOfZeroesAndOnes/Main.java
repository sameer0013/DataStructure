package LongestSubarrayWithEqualNumberOfZeroesAndOnes;

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int len=0,diff=0;
        // int c0=0,c1=0;
        
        for(int i=0;i<arr.length;i++){
            //approach 1 for finding ratio
            // if(arr[i]==0) c0++;
            // else c1++;
            // diff = c1-c0;

            if(arr[i]==0) diff--;
            else diff++;

            if(hm.containsKey(diff)){
                int idx = hm.get(diff);
                len = Math.max(len,(i-idx)); 
            }else{
                hm.put(diff,i);
            }
        }

        return len;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}


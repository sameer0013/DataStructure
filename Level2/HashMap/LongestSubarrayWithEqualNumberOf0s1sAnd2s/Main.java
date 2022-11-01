package LongestSubarrayWithEqualNumberOf0s1sAnd2s;

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0#0",-1);
        int dif1=0,dif2=0;
        int c0=0,c1=0,c2=0;
        int len=0;
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(val==0) c0++;
            else if(val==1) c1++;
            else c2++;

            dif1= c1-c0;
            dif2 = c2-c1;
            String inp= dif1+"#"+dif2;
            if(hm.containsKey(inp)){
                int idx = hm.get(inp);
                len = Math.max(len,(i-idx));
            }else{
                hm.put(inp,i);
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


package CountOfSubarraysWithEqualNumberOf0s1sAnd2s;

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("0#0",1);
        int diff1=0,diff2=0;
        int count=0;
        int c0=0,c1=0,c2=0;
        for(int val: arr){
            if(val==0) c0++;
            else if(val==1) c1++;
            else c2++;

            diff1 = c1-c0;
            diff2 = c2-c1;

            String inp = diff1 +"#"+diff2;
            if(hm.containsKey(inp)){
                int f = hm.get(inp);
                count +=f;
                hm.put(inp,f+1);
            }else{
                hm.put(inp,1);
            }
        }

        return count;
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


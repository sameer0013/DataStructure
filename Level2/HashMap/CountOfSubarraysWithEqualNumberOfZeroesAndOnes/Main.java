package CountOfSubarraysWithEqualNumberOfZeroesAndOnes;

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int count=0,ratio=0;
        for(int val: arr){
            if(val==0) ratio--;
            else ratio++;

            if(hm.containsKey(ratio)){
                int f = hm.get(ratio);
                count += f;
                hm.put(ratio,f+1);
            }else{
                hm.put(ratio,1);
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


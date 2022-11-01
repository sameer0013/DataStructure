import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ssf=0, len=0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++){
            ssf += arr[i];
            int rem = ssf%k;
            if(rem<0) rem +=k;
            if(hm.containsKey(rem)){
                int idx = hm.get(rem);
                int diff = i-idx;
                len = Math.max(len,diff);
            }else{
                hm.put(rem,i);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}

